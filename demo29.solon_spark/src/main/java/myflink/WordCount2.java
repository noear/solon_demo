package myflink;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.api.java.function.VoidFunction;
import scala.Tuple2;

import java.util.Arrays;
import java.util.Iterator;

public class WordCount2 {
    public static void main(String[] args) {
        SparkConf sparkConf = new SparkConf().setMaster("local").setAppName("wc_2");

        JavaSparkContext sc = new JavaSparkContext(sparkConf);

        JavaRDD<String> text = sc.textFile("test.txt");

        // 将文件中字符串拆分
        JavaRDD<String> word = text.flatMap(s -> Arrays.asList(s.split(" ")).iterator());

        // 转换为map 格式    例如"aa" -> {"aa",1}
        JavaPairRDD<String, Integer> paris = word.mapToPair(s -> new Tuple2<>(s, 1));

        // 根据key 相同的叠加，  先分组再计算
        JavaPairRDD<String, Integer> count = paris.reduceByKey((a, b) -> a + b);

        // map 中 key 和 value 调换， 调换后key为Integer格式，以便后面根据 key 排序，
        JavaPairRDD<Integer, String> tem = count.mapToPair(tuple2 -> new Tuple2<>(tuple2._2, tuple2._1));

        // 排序
        JavaPairRDD<Integer, String> sorted = tem.sortByKey(false);

        //遍历打印
        sorted.foreach(tuple2 -> {
            System.out.println(tuple2._1 + ":" + tuple2._2);
        });
    }
}

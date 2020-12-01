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

public class StreamingJob {
    public static void main(String[] args){
        SparkConf sparkConf = new SparkConf().setMaster("local").setAppName("wc_2");
        JavaSparkContext sc = new JavaSparkContext(sparkConf);
        JavaRDD<String> text = sc.textFile("test.txt");
        // 将文件中字符串拆分
        JavaRDD<String> word = text.flatMap(new FlatMapFunction<String, String>() {
            @Override
            public Iterator<String> call(String s) throws Exception {
                String[] str = s.split(" ");
                return Arrays.asList(str).iterator();
            }
        });
        // 转换为map 格式    例如"aa" -> {"aa",1}
        JavaPairRDD<String, Integer> paris = word.mapToPair(new PairFunction<String, String, Integer>() {
            @Override
            public Tuple2<String, Integer> call(String s) throws Exception {
                Tuple2<String,Integer> tuple2 = new Tuple2<>(s,1);
                return tuple2;
            }
        });
        // 根据key 相同的叠加，  先分组再计算
        JavaPairRDD<String,Integer> count =  paris.reduceByKey(new Function2<Integer, Integer, Integer>() {
            @Override
            public Integer call(Integer integer, Integer integer2) throws Exception {
                return integer+integer2;
            }
        });
        // map 中 key 和 value 调换， 调换后key为Integer格式，以便后面根据 key 排序，
        JavaPairRDD<Integer,String> tem =  count.mapToPair(new PairFunction<Tuple2<String,Integer>, Integer, String>() {
            @Override
            public Tuple2<Integer, String> call(Tuple2<String, Integer> tuple2) throws Exception {
                return new Tuple2<>(tuple2._2,tuple2._1);
            }
        });
        // 排序
        JavaPairRDD<Integer,String> sorted =  tem.sortByKey(false);

        //遍历打印
        sorted.foreach(new VoidFunction<Tuple2<Integer, String>>() {
            @Override
            public void call(Tuple2<Integer, String> integerStringTuple2) throws Exception {
                System.out.println(integerStringTuple2._1+":"+integerStringTuple2._2);
            }
        });
    }
}

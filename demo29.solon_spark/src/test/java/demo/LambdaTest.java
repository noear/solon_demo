package demo;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class LambdaTest {
    @Test
    public void MapReduceFilterTest() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        /*
         * 先过滤出3,4,5   平方后得9,16,25    相加得50
         */
        Integer result = list.stream()
                             .filter(x -> x > 2)
                             .map(x -> x * x)
                             .reduce((a, b) -> a + b)
                             .get();

        System.out.println(result);
    }
}

package demo;

import org.junit.Test;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class FluxDemo2Test {
    @Test
    public void test11() {
        Flux.generate(sink -> {
            sink.next("Hello");
            sink.complete();
        }).subscribe(System.out::println);
    }

    @Test
    public void test12() {
        Flux.generate(sink -> {
            sink.next(Arrays.asList("Hello", "World"));
            sink.complete();
        }).subscribe(System.out::println);
    }

    @Test
    public void test13() {
        final Random random = new Random();
        Flux.generate(ArrayList::new, (list, sink) -> {
            int value = random.nextInt(100);
            list.add(value);
            sink.next(value);
            if (list.size() == 10) {
                sink.complete();
            }
            return list;
        }).subscribe(System.out::println);
    }

    @Test
    public void test21(){
        Flux.create(sink -> {
            for (int i = 0; i < 10; i++) {
                sink.next(i);
            }
            sink.complete();
        }).subscribe(System.out::println);
    }
}

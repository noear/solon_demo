package demo;

import org.junit.Test;
import reactor.core.publisher.Flux;

public class FluxDemo4Test {
    @Test
    public void test1() {
        Flux.just(1, 0).map(x -> 1 / x).checkpoint("test").subscribe(System.out::println);
    }

    @Test
    public void test2_1() throws Exception {
        final Flux<Long> source = Flux.intervalMillis(1000)
                .take(10)
                .publish()
                .autoConnect();

        source.subscribe();

        Thread.sleep(5000);

        source.toStream()
                .forEach(System.out::println);
    }

    @Test
    public void test2_2() throws Exception {
        final Flux<Long> source = Flux.intervalMillis(1000)
                .take(10)
                .publish()
                .autoConnect();

        Thread.sleep(5000);

        source.toStream()
                .forEach(System.out::println);
    }
}

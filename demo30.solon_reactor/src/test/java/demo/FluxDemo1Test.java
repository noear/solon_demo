package demo;

import org.junit.Test;
import reactor.core.publisher.Flux;

import java.io.IOException;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class FluxDemo1Test {
    @Test
    public void test1() {
        Flux.just("Hello", "World").subscribe(System.out::println);
        Flux.fromArray(new Integer[]{1, 2, 3}).subscribe(System.out::println);
        Flux.empty().subscribe(System.out::println);
        Flux.range(1, 10).subscribe(System.out::println);

    }

    @Test
    public void test2() throws IOException {
        Flux.interval(Duration.of(1, ChronoUnit.SECONDS))
                .subscribe(System.out::println);

        //System.in.read();
    }

    @Test
    public void test3() throws IOException {
        Flux.intervalMillis(1000).subscribe(System.out::println);


        //System.in.read();
    }
}

package demo;

import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class FluxDemo3Test {
    @Test
    public void test11() {
        Flux.range(1, 110).buffer(20).subscribe(System.out::println);
    }

    @Test
    public void test12() {
        Flux.intervalMillis(100).bufferMillis(1001).take(2).toStream().forEach(System.out::println);
    }

    @Test
    public void test13() {
        Flux.range(1, 10).bufferUntil(i -> i % 2 == 0).subscribe(System.out::println);
    }

    @Test
    public void test14() {
        Flux.range(1, 10).bufferWhile(i -> i % 2 == 0).subscribe(System.out::println);
    }

    @Test
    public void test21() {
        Flux.range(1, 10).filter(i -> i % 2 == 0).subscribe(System.out::println);
    }

    @Test
    public void test31() {
        Flux.range(1, 100).window(20).subscribe(System.out::println);
    }

    @Test
    public void test32() {
        Flux.intervalMillis(100).windowMillis(1001).take(2).toStream().forEach(System.out::println);
    }

    @Test
    public void test41() {
        Flux.just("a", "b")
                .zipWith(Flux.just("c", "d", "e")) // like Flux.just("c", "d")
                .subscribe(System.out::println);
    }

    @Test
    public void test42() {
        Flux.just("a", "b")
                .zipWith(Flux.just("c", "d"), (s1, s2) -> String.format("%s-%s", s1, s2))
                .subscribe(System.out::println);
    }

    @Test
    public void test91() {
        Flux.range(1, 1000).take(10).subscribe(System.out::println);
    }

    @Test
    public void test92() {
        Flux.range(1, 1000).takeLast(10).subscribe(System.out::println);
    }

    @Test
    public void test93() {
        Flux.range(1, 1000).takeWhile(i -> i < 10)
                .subscribe(System.out::println);
    }

    @Test
    public void test94() {
        Flux.range(1, 1000).takeUntil(i -> i == 10)
                .subscribe(System.out::println);
    }

    @Test
    public void test10_1() {
        Flux.range(1, 100).reduce((x, y) -> x + y)
                .subscribe(System.out::println);
    }

    @Test
    public void test10_2() {
        Flux.range(1, 100).reduceWith(() -> 100, (x, y) -> x + y)
                .subscribe(System.out::println);
    }

    @Test
    public void test11_1() {
        Flux.merge(Flux.intervalMillis(0, 100).take(5), Flux.intervalMillis(50, 100).take(5))
                .toStream()
                .forEach(System.out::println);
    }

    @Test
    public void test11_2() {
        Flux.mergeSequential(Flux.intervalMillis(0, 100).take(5), Flux.intervalMillis(50, 100).take(5))
                .toStream()
                .forEach(System.out::println);
    }

    @Test
    public void test12_1() {
        Flux.just(5, 10)
                .flatMap(x -> Flux.intervalMillis(x * 10, 100).take(x))
                .toStream()
                .forEach(System.out::println);
    }

    @Test
    public void test15_1() {
        Flux.just(1, 2)
                .concatWith(Mono.error(new IllegalStateException()))
                .subscribe(System.out::println, System.err::println);

    }

    @Test
    public void test19_1() {
        Flux.just(1, 2)
                .concatWith(Mono.error(new IllegalStateException()))
                .retry(1)
                .subscribe(System.out::println);

    }

    @Test
    public void test20() {
        Flux.create(sink -> {
            sink.next(Thread.currentThread().getName());
            sink.complete();
        })
                .publishOn(Schedulers.single())
                .map(x -> String.format("[%s] %s", Thread.currentThread().getName(), x))
                .publishOn(Schedulers.elastic())
                .map(x -> String.format("[%s] %s", Thread.currentThread().getName(), x))
                .subscribeOn(Schedulers.parallel())
                .toStream()
                .forEach(System.out::println);
    }
}

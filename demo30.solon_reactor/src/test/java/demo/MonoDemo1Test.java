package demo;

import org.junit.Test;
import reactor.core.publisher.Mono;

import java.util.Optional;

public class MonoDemo1Test {
    @Test
    public void test1(){
        Mono.fromSupplier(() -> "Hello").subscribe(System.out::println);

        Mono.justOrEmpty(Optional.of("Hello")).subscribe(System.out::println);

        Mono.create(sink -> sink.success("Hello")).subscribe(System.out::println);
    }
}

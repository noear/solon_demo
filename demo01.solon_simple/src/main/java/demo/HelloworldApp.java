package demo;

import org.noear.solon.Solon;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.core.handle.Result;


@Controller
public class HelloworldApp {
    public static void main(String[] args) {
        Solon.start(HelloworldApp.class, args);
    }

    @Mapping("/")
    public Object helloworld(){
        return Result.succeed("hello world!");
    }
}

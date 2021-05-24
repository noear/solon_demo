package demo;

import lombok.extern.slf4j.Slf4j;
import org.noear.solon.Solon;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;

/**
 * @author noear 2021/5/24 created
 */
@Slf4j
@Controller
public class DemoApp {
    public static void main(String[] args){
        Solon.start(DemoApp.class, args);

        log.info("Solon 启动了");
    }

    @Mapping("/")
    public String hello(){
        log.info("hello at " + System.currentTimeMillis());

        return "hello world!";
    }
}

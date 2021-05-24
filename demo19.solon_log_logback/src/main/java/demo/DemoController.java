package demo;

import lombok.extern.slf4j.Slf4j;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Init;
import org.noear.solon.annotation.Mapping;

/**
 * @author noear 2021/5/24 created
 */
@Slf4j
@Controller
public class DemoController {

    @Init
    public void init(){
        log.info("---------------DemoApp init-----------");
    }

    @Mapping("/")
    public String hello(){
        log.info("hello at " + System.currentTimeMillis());

        return "hello world!";
    }
}

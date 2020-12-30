package stringboot_demo.controller;

import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Inject;
import org.noear.solon.annotation.Mapping;
import stringboot_demo.dso.HelloService;

/**
 * Springboot 不能使用 Solon 的容器资源
 *
 * Solon 可以使用 Springboot 的容器资源
 * */
@Controller
public class TestController {
    @Inject
    HelloService helloService;

    @Mapping("/test")
    public String home(String msg) throws Exception {
        return "solon test:" + helloService.hello();
    }
}

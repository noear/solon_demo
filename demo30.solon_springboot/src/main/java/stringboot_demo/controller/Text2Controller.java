package stringboot_demo.controller;

import org.noear.solon.annotation.Inject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import stringboot_demo.dso.HelloService;

/**
 * Springboot 不能使用 Solon 的容器资源
 *
 * Solon 可以使用 Springboot 的容器资源
 */
@RestController
public class Text2Controller {

    @Inject
    HelloService helloService;

    @RequestMapping("/test2")
    public String home(String msg) throws Exception {
        //使用Solon的手写特性赋值，进行懒加载

        return "springboot: " + helloService.hello(msg);
    }
}

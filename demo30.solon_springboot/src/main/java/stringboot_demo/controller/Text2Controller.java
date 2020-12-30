package stringboot_demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import stringboot_demo.dso.HelloService;

import javax.annotation.Resource;

/**
 * Springboot 不能使用 Solon 的容器资源
 *
 * Solon 可以使用 Springboot 的容器资源
 */
@RestController
public class Text2Controller {
    @Resource
    HelloService helloService;

    @RequestMapping("/test2")
    public String home(String msg) throws Exception {
        return "springboot test2:" + helloService.hello();
    }
}

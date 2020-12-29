package stringboot_demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import stringboot_demo.dso.HelloService;

import javax.annotation.Resource;

/**
 * @author noear 2020/12/28 created
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

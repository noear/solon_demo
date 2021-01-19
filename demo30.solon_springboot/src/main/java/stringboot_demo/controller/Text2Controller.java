package stringboot_demo.controller;

//import org.noear.solon.Solon;
//import org.noear.solon.core.Aop;
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

    HelloService helloService;

    @RequestMapping("/test2")
    public String home(String msg) throws Exception {
        //使用Solon的手写特性赋值，进行懒加载
        //
//        if(helloService == null){
//            helloService = Aop.get(HelloService.class);
//        }
//
//        String name = Solon.cfg().get("user.name");

        return "springboot: " + helloService.hello(msg);
    }
}

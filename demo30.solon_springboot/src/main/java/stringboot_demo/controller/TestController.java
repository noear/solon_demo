package stringboot_demo.controller;

import org.noear.solon.Utils;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Inject;
import org.noear.solon.annotation.Mapping;
import stringboot_demo.dso.HelloService;

@Controller
public class TestController {
    @Inject
    HelloService helloService;

    @Mapping("/test")
    public String home(String msg) throws Exception {
        return "solon test:" + helloService.hello();
    }
}

package webapp.client;

import org.apache.dubbo.config.annotation.Reference;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;
import webapp.protocol.HelloService;
import webapp.protocol.UserService;

@Controller
public class HelloConsume {
    @Reference(group = "hello")
    HelloService helloService;

    @Reference
    UserService userService;

    @Mapping("/")
    public String home(){
        return helloService.sayHello(userService.getUser("noear"));
    }
}

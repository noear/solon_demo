package webapp.client;

import org.apache.dubbo.config.annotation.Reference;
import org.noear.solon.annotation.XBean;
import org.noear.solon.annotation.XController;
import org.noear.solon.annotation.XMapping;
import webapp.protocol.HelloService;
import webapp.protocol.UserService;

@XBean
public class HelloConsume {
    @Reference
    HelloService helloService;

    @Reference
    UserService userService;

    @XMapping("/")
    public String home(){
        return helloService.sayHello(userService.getUser("noear"));
    }
}

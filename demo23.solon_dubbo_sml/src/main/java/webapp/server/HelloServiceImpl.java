package webapp.server;

import org.apache.dubbo.config.annotation.DubboService;
import webapp.protocol.HelloService;

@DubboService(group = "hello")
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        return "hello, " + name;
    }
}

package webapp.server;

import org.apache.dubbo.config.annotation.Service;
import webapp.protocol.HelloService;

@Service(group = "hello")
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        return "hello, " + name;
    }
}

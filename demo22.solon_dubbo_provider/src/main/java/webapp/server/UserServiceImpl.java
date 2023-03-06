package webapp.server;

import org.apache.dubbo.config.annotation.Service;
import org.noear.solon.annotation.ProxyComponent;
import webapp.protocol.UserService;

@ProxyComponent
public class UserServiceImpl implements UserService {
    @Override
    public String getUser(String name) {
        return name;
    }
}

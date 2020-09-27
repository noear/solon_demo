package webapp.server;

import org.apache.dubbo.config.annotation.Service;
import webapp.protocol.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public String getUser(String name) {
        return name;
    }
}

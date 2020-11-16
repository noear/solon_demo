package webapp.server;

import org.noear.solon.Solon;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Mapping;
import webapp.protocol.UserModel;
import webapp.protocol.UserService;

//开启bean的远程服务
@Component(remoting = true)
@Mapping("/user/")
public class RpcService implements UserService {
    public static void main(String[] args) {
        Solon.start(RpcService.class, args);
    }

    @Override
    public UserModel getUser(Integer userId) {
        UserModel model = new UserModel();
        model.setId(userId);
        model.setName("user-" + userId);

        return model;
    }
}

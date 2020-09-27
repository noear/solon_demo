package webapp.server;

import org.noear.solon.XApp;
import org.noear.solon.annotation.XBean;
import org.noear.solon.annotation.XMapping;
import webapp.protocol.UserModel;
import webapp.protocol.UserService;


@XMapping("/user/")
@XBean(remoting = true)
public class RpcService implements UserService {
    public static void main(String[] args) {
        XApp.start(RpcService.class, args);
    }

    @Override
    public UserModel getUser(Integer userId) {
        UserModel model = new UserModel();
        model.setId(userId);
        model.setName("user-" + userId);

        return model;
    }
}

package client;

import common.UserService;
import org.noear.nami.annotation.NamiClient;
import org.noear.snack.ONode;
import org.noear.solon.Solon;
import org.noear.solon.annotation.Component;
import org.noear.solon.core.Aop;

/**
 * @author noear 2021/4/22 created
 */
@Component
public class ClientApp {
    @NamiClient(upstream = "http://localhost:8080/", path = "/api/rpc/user/")
    UserService userService;

    public static void main(String[] args) {
        Solon.start(ClientApp.class, args, app -> app.enableHttp(false));

        ClientApp tmp = Aop.get(ClientApp.class);
        Object user = tmp.userService.getUser();
        System.out.println(ONode.stringify(user));
    }
}

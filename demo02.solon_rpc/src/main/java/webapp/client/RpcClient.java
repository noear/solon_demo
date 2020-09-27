package webapp.client;

import org.noear.fairy.annotation.EnableFairyClients;
import org.noear.fairy.annotation.FairyClient;
import org.noear.solon.XApp;
import org.noear.solon.annotation.XBean;
import org.noear.solon.core.Aop;
import webapp.protocol.UserModel;
import webapp.protocol.UserService;

@EnableFairyClients
@XBean
public class RpcClient {
    public static void main(String[] args) {
        XApp.start(RpcClient.class, args, app->app.enableHttp(false));

        RpcClient client = Aop.get(RpcClient.class);
        client.test();
    }

    @FairyClient("http://localhost:8080/user/")
    UserService userService;

    public void test(){
        UserModel user = userService.getUser(12);
        System.out.println(user);
    }
}

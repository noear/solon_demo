package webapp.client;

import org.noear.fairy.annotation.EnableFairyClients;
import org.noear.fairy.annotation.FairyClient;
import org.noear.solon.XApp;
import org.noear.solon.annotation.XBean;
import org.noear.solon.core.Aop;
import org.noear.solon.core.XBridge;
import webapp.protocol.UserModel;
import webapp.protocol.UserService;

@EnableFairyClients
@XBean
public class RpcClient {
    public static void main(String[] args) {
        XBridge.upstreamFactorySet(new RpcUpstreamFactory());

        XApp.start(RpcClient.class, args, app -> app.enableHttp(false));

        RpcClient client = Aop.get(RpcClient.class);
        client.test();
    }

    //直接指定服务端地址
    @FairyClient("http://localhost:8080/user/")
    UserService userService;

    //使用负载
    @FairyClient("local:/user/")
    UserService userService2;

    public void test() {
        UserModel user = userService.getUser(12);
        System.out.println(user);

        user = userService2.getUser(23);
        System.out.println(user);
    }
}

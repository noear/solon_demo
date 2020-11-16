package webapp.client;

import org.noear.fairy.annotation.EnableFairyClient;
import org.noear.fairy.annotation.FairyClient;
import org.noear.solon.Solon;
import org.noear.solon.annotation.Component;
import org.noear.solon.core.Aop;
import webapp.protocol.UserModel;
import webapp.protocol.UserService;

@EnableFairyClient
@Component
public class RpcClient {
    public static void main(String[] args) {
        //开启ioc服务，并关掉http端口（免得冲突）
        Solon.start(RpcClient.class, args, app -> app.enableHttp(false));

        //Aop获取一个bean
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

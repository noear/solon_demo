package demo.client;

import org.noear.solon.Solon;
import org.noear.solon.core.message.Listener;
import org.noear.solon.core.message.Message;
import org.noear.solon.core.message.Session;
import org.noear.solon.extend.socketd.SocketD;

public class ClientApp {
    public static void main(String[] args) throws Throwable {
        Solon.start(ClientApp.class, args);

        //
        //手动模式：适用于服务端不固定的
        //
        Session session = SocketD.create("localhost", 28080);
        session.listener(new Listener() {
            @Override
            public void onOpen(Session session) {
                System.out.println("客户端1：我要打开了...");
            }

            @Override
            public void onMessage(Session session, Message message, boolean messageIsString) {
                //
                // message.body 要自己解码一下；如果是字符串，可以：message.toString();
                //
                System.out.println("客户端1：我收到了：" + message);
            }
        });

        //可以先发个握手包
        //session.sendHandshake("Token=12",null);

        //启用自动心跳包
        session.sendHeartbeatAuto(30);



        //卡一下；因为没有任何别的服务启动
        System.in.read();
    }
}

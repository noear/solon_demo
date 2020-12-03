package demo.server;

import org.noear.solon.annotation.ListenEndpoint;
import org.noear.solon.core.message.Listener;
import org.noear.solon.core.message.Message;
import org.noear.solon.core.message.Session;

@ListenEndpoint
public class ServerListener implements Listener {
    @Override
    public void onOpen(Session session) {
        System.out.println("服务端：有人来了");

        session.send("你好啊...");

        ServerApp.status.complete(true);
    }

    @Override
    public void onMessage(Session session, Message message, boolean messageIsString) {
        if(message.flag() == -2){
            System.out.println("服务端：我收到心跳");
        }else {
            System.out.println("服务端：我收到：" + message);
        }
    }
}
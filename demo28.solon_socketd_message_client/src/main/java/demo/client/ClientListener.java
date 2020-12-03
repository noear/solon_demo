package demo.client;

import org.noear.solon.core.message.Listener;
import org.noear.solon.core.message.Message;
import org.noear.solon.core.message.Session;
import org.noear.solon.extend.socketd.annotation.ClientListenEndpoint;

@ClientListenEndpoint(host = "localhost", port = 28080)
public class ClientListener implements Listener {
    @Override
    public void onOpen(Session session) {
        System.out.println("客户端：我连上了...");
    }

    @Override
    public void onMessage(Session session, Message message, boolean messageIsString) {
        System.out.println("客户端：我收到了：" + message);
    }
}

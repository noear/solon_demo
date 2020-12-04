package demo.client;

import org.noear.solon.core.message.Listener;
import org.noear.solon.core.message.Message;
import org.noear.solon.core.message.Session;
import org.noear.solon.extend.socketd.annotation.ClientEndpoint;

/**
 * 注解模式；适用于固定的服务端
 * */
@ClientEndpoint(uri = "tcp://localhost:28080", handshakeHeader = "Token=Xxxxx;Sn=12ddd")
public class ClientListener implements Listener {
    @Override
    public void onOpen(Session session) {
        System.out.println("客户端2：我要打开了...");
    }

    @Override
    public void onMessage(Session session, Message message, boolean messageIsString) {
        //
        // 配置，就是在此处收到
        //
        System.out.println("客户端2：我收到了：" + message);

        //message.bodyAsString(); //获取 body 的字符串形态
    }
}

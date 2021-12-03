package demo.controller;

import org.noear.solon.Utils;
import org.noear.solon.annotation.ServerEndpoint;
import org.noear.solon.core.message.Listener;
import org.noear.solon.core.message.Message;
import org.noear.solon.core.message.Session;

import java.io.IOException;

/**
 * @author noear 2021/4/22 created
 */
@ServerEndpoint(value = "**")
public class WebSocket implements Listener {
    @Override
    public void onOpen(Session session) {
        //请求参数（想签权，可以在这里做；有问题请求，这里可以close掉）
        System.out.println(session.paramMap());

        String name = session.path().split("/")[1];
    }

    @Override
    public void onMessage(Session session, Message message) throws IOException {
        //请求地址
        System.out.println(session.path() + ":" + message.resourceDescriptor());

        //分发给所有客户端
        session.getOpenSessions().forEach(s -> {
            s.send(message.bodyAsString() + "-" + s.getOpenSessions().size());
        });
    }
}

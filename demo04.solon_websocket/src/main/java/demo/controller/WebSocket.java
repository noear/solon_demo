package demo.controller;

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
    public void onMessage(Session session, Message message) throws IOException {
        System.out.println(session.path() + ":" + message.resourceDescriptor());

        //分发给所有客户端
        session.getOpenSessions().forEach(s -> {
            s.send(message.bodyAsString() + "-" + s.getOpenSessions().size());
        });
    }
}

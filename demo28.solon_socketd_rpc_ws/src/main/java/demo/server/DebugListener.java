package demo.server;

import org.noear.solon.annotation.ServerEndpoint;
import org.noear.solon.core.message.Listener;
import org.noear.solon.core.message.Message;
import org.noear.solon.core.message.Session;

import java.io.IOException;

@ServerEndpoint("**")
public class DebugListener implements Listener{
    @Override
    public void onMessage(Session session, Message message, boolean messageIsString) throws IOException {
        System.out.println(message.toString());
    }
}

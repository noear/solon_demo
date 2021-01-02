package demo.server;

import demo.utils.EncryptUtils;
import org.noear.solon.Solon;
import org.noear.solon.socketd.SocketD;
import org.noear.solon.socketd.protocol.MessageProtocolSecret;

public class ServerDemo {
    public static void main(String[] args) {
        Solon.start(ServerDemo.class, args, app -> {
            app.enableSocket(true);
            app.enableWebSocketD(true);
        });
    }
}

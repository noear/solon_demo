package demo.server;

import org.noear.solon.Solon;
import org.noear.solon.extend.socketd.SocketD;
import org.noear.solon.extend.socketd.protocol.MessageProtocolCompress;

public class ServerDemo {
    public static void main(String[] args) {
        Solon.start(ServerDemo.class, args, app -> {
            app.enableSocket(true);

            //SiteD 启用压缩协议（默认超过1k才进行压缩）::要与客户端配套启用
            SocketD.setProtocol(new MessageProtocolCompress());
        });
    }
}

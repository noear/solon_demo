package demo.server;

import demo.utils.EncryptUtils;
import org.noear.solon.Solon;
import org.noear.solon.extend.socketd.SocketD;
import org.noear.solon.extend.socketd.protocol.MessageProtocolCompress;
import org.noear.solon.extend.socketd.protocol.MessageProtocolSecret;

public class ServerDemo {
    public static void main(String[] args) {
        Solon.start(ServerDemo.class, args, app -> {
            app.enableSocket(true);

            //SiteD 启用压缩协议（默认超过1k才进行压缩）::要与客户端配套启用
            SocketD.setProtocol(new MessageProtocolSecret() {
                @Override
                public byte[] encrypt(byte[] bytes) throws Exception {
                    return EncryptUtils.aesEncrypt(bytes,"pLft36Ok5zfmP6zI");
                }

                @Override
                public byte[] decrypt(byte[] bytes) throws Exception {
                    return EncryptUtils.aesDecrypt(bytes,"pLft36Ok5zfmP6zI");
                }
            });
        });
    }
}

package demo.client;

import demo.service.HelloRpcService;
import demo.utils.EncryptUtils;
import org.noear.solon.Solon;
import org.noear.solon.extend.socketd.SocketD;
import org.noear.solon.extend.socketd.protocol.MessageProtocolCompress;
import org.noear.solon.extend.socketd.protocol.MessageProtocolSecret;

public class ClientDemo {
    public static void main(String[] args) {
        Solon.start(ClientDemo.class, args, app->{
            //SocketD 启用压缩协议（默认超过1k才进行压缩）::要与服务端配套启用
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

        //[客户端] 调用 [服务端] 的 rpc
        //
        HelloRpcService rpc = SocketD.create("tcp://localhost:28080", HelloRpcService.class);

        System.out.println("RPC result: " + rpc.hello("noear"));
    }
}

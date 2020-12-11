package demo.client;

import demo.service.HelloRpcService;
import org.noear.solon.Solon;
import org.noear.solon.extend.socketd.SocketD;
import org.noear.solon.extend.socketd.protocol.MessageProtocolCompress;

public class ClientDemo {
    public static void main(String[] args) {
        Solon.start(ClientDemo.class, args, app->{
            //SocketD 启用压缩协议（默认超过1k才进行压缩）::要与服务端配套启用
            SocketD.setProtocol(new MessageProtocolCompress());
        });

        //[客户端] 调用 [服务端] 的 rpc
        //
        HelloRpcService rpc = SocketD.create("tcp://localhost:28080", HelloRpcService.class);

        System.out.println("RPC result: " + rpc.hello("noear"));
    }
}

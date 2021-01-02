package demo.client;

import demo.service.HelloRpcService;
import demo.utils.EncryptUtils;
import org.noear.solon.Solon;
import org.noear.solon.socketd.SocketD;
import org.noear.solon.socketd.protocol.MessageProtocolSecret;

public class ClientDemo {
    public static void main(String[] args) {
        Solon.start(ClientDemo.class, args, app-> app.enableHttp(false));

        //[客户端] 调用 [服务端] 的 rpc
        //
        HelloRpcService rpc = SocketD.create("tcp://localhost:28080", HelloRpcService.class);

        System.out.println("RPC result: " + rpc.hello("noear"));
    }
}

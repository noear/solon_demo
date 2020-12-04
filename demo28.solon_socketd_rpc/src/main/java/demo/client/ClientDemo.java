package demo.client;

import demo.service.HelloRpcService;
import org.noear.solon.Solon;
import org.noear.solon.extend.socketd.SocketD;

public class ClientDemo {
    public static void main(String[] args) {
        Solon.start(ClientDemo.class, args);

        HelloRpcService rpc = SocketD.create("tcp://localhost:28080", HelloRpcService.class);

        System.out.println(rpc.hello("noear"));
    }
}

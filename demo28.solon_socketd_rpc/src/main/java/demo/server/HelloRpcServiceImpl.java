package demo.server;

import demo.service.HelloRpcService;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.core.handle.MethodType;

@Mapping(value = "/demoe/rpc", method = MethodType.SOCKET)
@Component(remoting = true)
public class HelloRpcServiceImpl implements HelloRpcService {
    public String hello(String name) {
//        NameRpcService rpc = SocketD.create(Context.current(), NameRpcService.class);
//        name = rpc.name(name);

        return "name=" + name;
    }
}

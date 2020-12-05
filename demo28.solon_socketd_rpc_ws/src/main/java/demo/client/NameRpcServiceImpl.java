package demo.client;

import demo.service.NameRpcService;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.core.handle.Context;
import org.noear.solon.core.handle.MethodType;

//
//注意method的区别（也可以同时加 SOCKET 和 WEBSOCKET）
//
@Mapping(value = "/demoe/rpc/name", method = {MethodType.WEBSOCKET})
@Component(remoting = true)
public class NameRpcServiceImpl implements NameRpcService {
    @Override
    public String name(String name) {
        return name;
    }
}

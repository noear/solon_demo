package demo.client;

import demo.service.NameRpcService;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.annotation.Remoting;
import org.noear.solon.core.handle.Context;
import org.noear.solon.core.handle.MethodType;

@Mapping(value = "/demoe/rpc/name", method = MethodType.SOCKET)
@Remoting
public class NameRpcServiceImpl implements NameRpcService {
    @Override
    public String name(String name) {
        return name;
    }
}

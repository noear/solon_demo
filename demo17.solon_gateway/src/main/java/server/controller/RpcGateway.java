package server.controller;

import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.core.handle.Gateway;
import server.dso.remote.UserServiceImpl;

/**
 * 内部RPC调用模式
 * @author noear 2021/4/22 created
 */
@Mapping("/api/rpc/**")
@Component
public class RpcGateway extends Gateway {
    @Override
    protected void register() {
        before((c)->{
            c.attrSet("@render","@type_json");
        });

        //添加服务
        add(UserServiceImpl.class, true);
    }
}

package server.controller;

import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.core.handle.Context;
import org.noear.solon.core.handle.Gateway;
import server.dso.remote.UserServiceImpl;

/**
 * 对第三方提供服务
 *
 * @author noear 2021/4/22 created
 */
@Mapping("/api/rest/**")
@Component
public class ApiGateway extends Gateway {
    @Override
    protected void register() {
        //或者由此
        before(c->c.attrSet("@render","@json"));

        //添加服务
        add(UserServiceImpl.class, true);
    }
}

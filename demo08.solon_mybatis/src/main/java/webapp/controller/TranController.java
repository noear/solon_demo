package webapp.controller;

import org.noear.solon.annotation.XController;
import org.noear.solon.annotation.XInject;
import org.noear.solon.annotation.XMapping;
import org.noear.solon.extend.mybatis.Df;
import org.noear.solon.extend.mybatis.MybatisProxy;
import webapp.dso.mapper.AppxMapper;

/**
 * 事务
 * */
@XMapping("/tran/")
@XController
public class TranController {
    @XInject
    AppxMapper appxMapper;

    /**
     * mybatis-solon-plugin 的事务，需要通过 MybatisProxy 发起
     *
     * solon 不目前支持注解事务，说明出于性能考虑
     * */
    @Df("db1f")
    MybatisProxy proxy;

    @XMapping("test")
    public Object test() throws Throwable{
        return proxy.tran((s)->{
            s.result = appxMapper.appx_get();
        });
    }
}

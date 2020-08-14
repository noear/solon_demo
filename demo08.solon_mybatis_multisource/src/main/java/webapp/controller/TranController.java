package webapp.controller;

import org.noear.solon.annotation.XController;
import org.noear.solon.annotation.XInject;
import org.noear.solon.annotation.XMapping;
import org.noear.solon.annotation.XTran;
import org.noear.solon.extend.mybatis.Df;
import webapp.dso.mapper.AppxMapper;

/**
 * 事务演示
 *
 * @Df 可注入 Mapper, SqlSession, SqlSessionFactory, MybatisProxy
 * */
@XMapping("/tran/")
@XController
public class TranController {
    @XInject
    AppxMapper appxMapper;

    /**
     * mybatis-solon-plugin 的事务，需要通过 MybatisProxy 发起
     * <p>
     * solon 不目前支持注解事务，说明出于性能考虑
     */
    @XTran("db1f")
    @XMapping("test")
    public Object test() throws Throwable {
        return appxMapper.appx_get();
    }
}

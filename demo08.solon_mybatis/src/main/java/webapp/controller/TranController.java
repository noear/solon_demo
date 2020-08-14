package webapp.controller;

import org.noear.solon.annotation.XController;
import org.noear.solon.annotation.XInject;
import org.noear.solon.annotation.XMapping;
import org.noear.solon.annotation.XTran;
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

    @XTran
    @XMapping("test")
    public Object test() throws Throwable {
         appxMapper.appx_add();

         return "OK";
    }

    @XTran
    @XMapping("test2")
    public Object test2() throws Throwable {
        appxMapper.appx_add();

        throw new RuntimeException("不让你加");

        //return "OK";
    }
}

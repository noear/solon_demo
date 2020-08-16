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

    @XTran("db1")
    @XMapping("test")
    public void test() throws Throwable {
        //添加成功
        //
        appxMapper.appx_add();
    }

    @XTran("db1")
    @XMapping("test2")
    public void test2() throws Throwable {
        //添加会失败，因为在事务里出异常了
        //
        appxMapper.appx_add();

        throw new RuntimeException("不让你加");
    }
}

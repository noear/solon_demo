package webapp.controller;

import org.noear.solon.annotation.XController;
import org.noear.solon.annotation.XInject;
import org.noear.solon.annotation.XMapping;
import webapp.dso.mapper.AppxMapper;

/**
 * 事务演示
 *
 * @Df 可注入 Mapper, SqlSession, SqlSessionFactory, MybatisProxy
 * */
@XMapping("/page/")
@XController
public class PageController {
    @XInject
    AppxMapper appxMapper;


    @XMapping("test")
    public Object test() throws Throwable{
        return appxMapper.appx_get_page();
    }
}

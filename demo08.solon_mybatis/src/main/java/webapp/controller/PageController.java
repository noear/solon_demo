package webapp.controller;

import com.jn.sqlhelper.dialect.pagination.SqlPaginations;
import org.noear.solon.annotation.XController;
import org.noear.solon.annotation.XInject;
import org.noear.solon.annotation.XMapping;
import org.noear.solon.extend.mybatis.Df;
import org.noear.solon.extend.mybatis.MybatisProxy;
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

        SqlPaginations.preparePagination(2,2);

        return appxMapper.appx_get_page();
    }
}

package webapp.controller;

import com.jn.sqlhelper.dialect.pagination.SqlPaginations;
import org.noear.solon.annotation.XController;
import org.noear.solon.annotation.XInject;
import org.noear.solon.annotation.XMapping;
import webapp.dso.mapper.AppxMapper;

/**
 * 分面演示（使用sqlhelper组件）
 *
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

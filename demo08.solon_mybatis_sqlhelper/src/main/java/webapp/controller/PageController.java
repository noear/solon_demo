package webapp.controller;

import com.jn.sqlhelper.dialect.pagination.SqlPaginations;
import org.apache.ibatis.solon.annotation.Db;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;
import webapp.dso.mapper.AppxMapper;

/**
 * 分面演示（使用 sqlhelper 组件）
 *
 * */
@Mapping("/page/")
@Controller
public class PageController {
    @Db
    AppxMapper appxMapper;

    @Mapping("test")
    public Object test() throws Throwable{
        SqlPaginations.preparePagination(2,2);

       return appxMapper.appx_get_page();

    }
}

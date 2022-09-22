package webapp.controller;

import org.beetl.sql.core.SQLManager;
import org.beetl.sql.solon.annotation.Db;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Inject;
import org.noear.solon.annotation.Mapping;
import webapp.dso.dao.AppxDao;
import webapp.dso.mapper.SqlMapper;

@Mapping("/demo/")
@Controller
public class DemoController {
    /**
     * 使用SqlMapper默认的数据库注入
     * */
    @Db
    SqlMapper sqlMapper1;

    @Db
    SQLManager sqlManager;

    @Db
    AppxDao appxDao;


    @Mapping("/test")
    public Object test() throws Exception{

        return appxDao.single(1);

        //return sqlMapper1.appx_get2(1);
    }

    @Mapping("/test2")
    public Object test2() throws Exception{
        return sqlMapper1.appx_getlist(1);
    }
}

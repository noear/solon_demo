package webapp.controller;

import org.beetl.sql.ext.solon.Db;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;
import webapp.dso.mapper.SqlMapper;

@Mapping("/demo/")
@Controller
public class DemoController {
    /**
     * 使用SqlMapper默认的数据库注入
     * */
    @Db
    SqlMapper sqlMapper1;


    @Mapping("/test")
    public Object test() throws Exception{
        return sqlMapper1.appx_get2(1);
    }

    @Mapping("/test2")
    public Object test2() throws Exception{
        return sqlMapper1.appx_getlist(1);
    }
}

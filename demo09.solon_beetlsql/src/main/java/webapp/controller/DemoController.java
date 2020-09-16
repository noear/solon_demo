package webapp.controller;

import org.beetl.sql.ext.solon.Db;
import org.noear.solon.annotation.XController;
import org.noear.solon.annotation.XMapping;
import webapp.dso.mapper.SqlMapper;

@XMapping("/demo/")
@XController
public class DemoController {
    /**
     * 使用SqlMapper默认的数据库注入
     * */
    @Db
    SqlMapper sqlMapper1;


    @XMapping("/test")
    public Object test() throws Exception{
        return sqlMapper1.appx_get2(1);
    }

    @XMapping("/test2")
    public Object test2() throws Exception{
        return sqlMapper1.appx_getlist(1);
    }
}

package webapp.controller;

import org.noear.solon.annotation.XController;
import org.noear.solon.annotation.XMapping;
import org.noear.solon.extend.beetlsql.Db;
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
    public Object db1() throws Exception{
        return sqlMapper1.appx_get2(1);
    }
}

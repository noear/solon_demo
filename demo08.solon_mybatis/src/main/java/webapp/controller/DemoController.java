package webapp.controller;

import org.noear.solon.annotation.XController;
import org.noear.solon.annotation.XInject;
import org.noear.solon.annotation.XMapping;
import org.noear.weed.annotation.Db;
import webapp.dso.mapper.SqlMapper;

@XController
public class DemoController {
    /**
     * 使用SqlMapper默认的数据库注入
     * */
    @XInject
    SqlMapper sqlMapper1;

//    //也可以-使用指定数据库注入
//    @Db("db1")
//    SqlMapper sqlMapper1;

    /**
     * 使用指定数据库注入
     * */
    @Db("db2")
    SqlMapper sqlMapper2;

    @XMapping("/db1")
    public Object db1() throws Exception{
        return sqlMapper1.appx_get2(1);
    }

    @XMapping("/db2")
    public Object db2() throws Exception{
        return sqlMapper2.appx_get2(1);
    }
}

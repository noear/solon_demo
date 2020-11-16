package webapp.controller;

import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Inject;
import org.noear.solon.annotation.Mapping;
import org.noear.weed.annotation.Db;
import webapp.dso.mapper.SqlMapper;

@Mapping("/demo/")
@Controller
public class DemoController {
    /**
     * 使用SqlMapper默认的数据库注入
     * */
    @Inject
    SqlMapper sqlMapper1;


    @Mapping("/test")
    public Object db1() throws Exception{
        return sqlMapper1.appx_get2(1);
    }
}

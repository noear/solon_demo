package webapp.controller;

import org.apache.ibatis.ext.solon.Db;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Inject;
import org.noear.solon.annotation.Mapping;
import webapp.dso.mapper.AppxMapper;
import webapp.model.AppxModel;

/**
 * 分包模式，一开始就被会话工厂mapperScan()并关联好了
 * */
@Mapping("/demo/")
@Controller
public class DemoController {
    @Db
    AppxMapper appxMapper;

    @Mapping("test")
    public AppxModel test(){
        return appxMapper.appx_get();
    }

}

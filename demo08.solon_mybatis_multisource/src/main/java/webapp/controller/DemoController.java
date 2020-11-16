package webapp.controller;

import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Inject;
import org.noear.solon.annotation.Mapping;
import webapp.dso.mapper.AppxMapper;
import webapp.dso.mapper.Appx2Mapper;
import webapp.model.AppxModel;

/**
 * 分包模式，一开始就被会话工厂mapperScan()并关联好了
 * */
@Mapping("/demo/")
@Controller
public class DemoController {
    @Inject
    AppxMapper appxMapper;

    @Inject
    Appx2Mapper appxMapper2;

    @Mapping("test")
    public AppxModel test(){
        return appxMapper.appx_get();
    }

    @Mapping("test2")
    public AppxModel test2(){
        return appxMapper2.appx_get2(48);
    }

}

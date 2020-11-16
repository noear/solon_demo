package webapp.controller;

import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Inject;
import org.noear.solon.annotation.Mapping;
import webapp.dso.db1.AppxMapper;
import webapp.dso.db2.Appx2Mapper;

@Mapping("/demo/")
@Controller
public class DemoController {
    //已被 Config 的 @MapperScan 生成bean了
    @Inject
    AppxMapper appxMapper;

    //已被 Config2 的 @MapperScan 生成bean了
    @Inject
    Appx2Mapper appxMapper2;

    @Mapping("/test")
    public Object test(){
        return appxMapper.appx_get();
    }

    @Mapping("/test2")
    public Object test2(){
        return appxMapper2.appx_get2(48);
    }

}

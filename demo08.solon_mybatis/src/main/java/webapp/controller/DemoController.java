package webapp.controller;

import org.noear.solon.annotation.XController;
import org.noear.solon.annotation.XInject;
import org.noear.solon.annotation.XMapping;
import webapp.dso.mapper.AppxMapper;
import webapp.dso.mapper.Appx2Mapper;

@XMapping("/demo/")
@XController
public class DemoController {
    //已被 Config 的 @MapperScan 生成bean了
    @XInject
    AppxMapper appxMapper;

    //已被 Config2 的 @MapperScan 生成bean了
    @XInject
    Appx2Mapper appxMapper2;

    @XMapping("/test")
    public Object test(){
        return appxMapper.appx_get();
    }

    @XMapping("/test2")
    public Object test2(){
        return appxMapper2.appx_get2(48);
    }

}

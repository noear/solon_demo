package webapp.controller;

import org.noear.solon.annotation.XController;
import org.noear.solon.annotation.XInject;
import org.noear.solon.annotation.XMapping;
import webapp.dso.mapper.AppxMapper;
import webapp.dso.mapper.Appx2Mapper;
import webapp.model.AppxModel;

@XMapping("/demo/")
@XController
public class DemoController {
    @XInject
    AppxMapper appxMapper;

    @XInject
    Appx2Mapper appxMapper2;

    @XMapping("test")
    public AppxModel test(){
        return appxMapper.appx_get();
    }

    @XMapping("test2")
    public AppxModel test2(){
        return appxMapper2.appx_get2(48);
    }

}

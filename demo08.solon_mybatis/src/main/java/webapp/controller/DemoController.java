package webapp.controller;

import org.noear.solon.annotation.XController;
import org.noear.solon.annotation.XInject;
import org.noear.solon.annotation.XMapping;
import webapp.dso.mapper.AppxMapper;
import webapp.model.AppxModel;

/**
 * 分包模式，一开始就被会话工厂mapperScan()并关联好了
 * */
@XMapping("/demo/")
@XController
public class DemoController {
    @XInject
    AppxMapper appxMapper;

    @XMapping("test")
    public AppxModel test(){
        return appxMapper.appx_get();
    }

}

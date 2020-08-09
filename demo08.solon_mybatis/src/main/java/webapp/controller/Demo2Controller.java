package webapp.controller;

import org.noear.solon.annotation.XController;
import org.noear.solon.annotation.XInject;
import org.noear.solon.annotation.XMapping;
import webapp.dso.mapper.Appx2Mapper;
import webapp.dso.mapper.AppxMapper;
import webapp.model.AppxModel;

/**
 * 注解模式，在注入指定具体的会话工厂
 * */
@XMapping("/demo2/")
@XController
public class Demo2Controller {
    @XInject("db1f")
    AppxMapper appxMapper;

    @XInject("db2f")
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

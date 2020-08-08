package webapp.controller;

import org.noear.solon.annotation.XController;
import org.noear.solon.annotation.XInject;
import org.noear.solon.annotation.XMapping;
import webapp.dso.db1.AppxMapper;
import webapp.dso.db2.AppxMapper2;

@XController
public class DemoController {
    @XInject
    AppxMapper appxMapper;

    @XInject
    AppxMapper2 appxMapper2;

    @XMapping("/test")
    public Object test(){
        return appxMapper.appx_get();
    }

    @XMapping("/test2")
    public Object test2(){
        return appxMapper.appx_get();
    }
}

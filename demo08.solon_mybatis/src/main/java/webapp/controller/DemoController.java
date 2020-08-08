package webapp.controller;

import org.noear.solon.annotation.XController;
import org.noear.solon.annotation.XInject;
import org.noear.solon.annotation.XMapping;
import org.noear.solon.extend.mybatis.Df;
import webapp.dso.db1.AppxMapper;
import webapp.dso.db2.Appx2Mapper;

@XController
public class DemoController {
    //已被 Config 的 @MapperScan 生成bean了
    @XInject
    AppxMapper appxMapper;

    //已被 Config2 的 @MapperScan 生成bean了
    @XInject
    Appx2Mapper appxMapper2;

    //通过 Mapper 指定 SqlSessionFactory，并注入
    @Df("db1f2")
    AppxMapper appxMapper22;

    @XMapping("/test")
    public Object test(){
        return appxMapper.appx_get();
    }

    @XMapping("/test2")
    public Object test2(){
        return appxMapper2.appx_get2(48);
    }

    @XMapping("/test22")
    public Object test22(){
        return appxMapper22.appx_get();
    }
}

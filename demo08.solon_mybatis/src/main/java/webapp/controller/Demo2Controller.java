package webapp.controller;

import org.noear.solon.annotation.XController;
import org.noear.solon.annotation.XInject;
import org.noear.solon.annotation.XMapping;
import org.noear.solon.extend.mybatis.Df;
import org.noear.solon.extend.mybatis.MybatisProxy;
import webapp.dso.db1.AppxMapper;
import webapp.dso.db2.Appx2Mapper;

import java.sql.SQLException;


@XMapping("/demo2/")
@XController
public class Demo2Controller {
    @Df("db1f")
    AppxMapper appxMapper;

    //已被 Config2 的 @MapperScan 生成bean了
    @Df("db2f")
    Appx2Mapper appxMapper2;

    @Df("db1f")
    MybatisProxy proxy;

    @XMapping("/test")
    public Object test() throws SQLException {
        return proxy.tran((session)->{
            session.result = appxMapper.appx_get();
        });
    }

    @XMapping("/test2")
    public Object test2(){
        return appxMapper2.appx_get2(48);
    }

}


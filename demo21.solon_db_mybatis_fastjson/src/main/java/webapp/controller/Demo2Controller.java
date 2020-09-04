package webapp.controller;

import org.noear.solon.annotation.XController;
import org.noear.solon.annotation.XMapping;
import org.noear.solon.annotation.XTran;
import org.noear.solon.extend.mybatis.Db;
import webapp.dso.db1.AppxMapper;
import webapp.dso.db2.Appx2Mapper;

import java.sql.SQLException;


@XMapping("/demo2/")
@XController
public class Demo2Controller {
    @Db("db1")
    AppxMapper appxMapper;

    //已被 Config2 的 @MapperScan 生成bean了
    @Db("db2")
    Appx2Mapper appxMapper2;

    @XTran
    @XMapping("/test")
    public Object test() throws SQLException {
        return appxMapper.appx_get();
    }

    @XMapping("/test2")
    public Object test2() {
        return appxMapper2.appx_get2(48);
    }

}


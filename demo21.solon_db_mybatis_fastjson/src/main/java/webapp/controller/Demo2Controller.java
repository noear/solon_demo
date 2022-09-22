package webapp.controller;

import org.apache.ibatis.solon.annotation.Db;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.data.annotation.Tran;
import webapp.dso.db1.AppxMapper;
import webapp.dso.db2.Appx2Mapper;

import java.sql.SQLException;


@Mapping("/demo2/")
@Controller
public class Demo2Controller {
    @Db("db1")
    AppxMapper appxMapper;

    //已被 Config2 的 @MapperScan 生成bean了
    @Db("db2")
    Appx2Mapper appxMapper2;

    @Tran
    @Mapping("/test")
    public Object test() throws SQLException {
        return appxMapper.appx_get();
    }

    @Mapping("/test2")
    public Object test2() {
        return appxMapper2.appx_get2(48);
    }

}


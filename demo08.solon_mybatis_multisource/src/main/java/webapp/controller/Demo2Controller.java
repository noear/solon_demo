package webapp.controller;

import org.apache.ibatis.ext.solon.Db;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;
import webapp.dso.mapper.Appx2Mapper;
import webapp.dso.mapper.AppxMapper;
import webapp.model.AppxModel;

/**
 * 注解模式，通过@Db注入，并指定具体的会话工厂
 *
 * @Db 可注入 Mapper, SqlSession, SqlSessionFactory, MybatisProxy
 * */
@Mapping("/demo2/")
@Controller
public class Demo2Controller {
    @Db("db1")
    AppxMapper appxMapper;

    @Db("db2")
    Appx2Mapper appxMapper2;

    @Mapping("test")
    public AppxModel test(){
        return appxMapper.appx_get();
    }

    @Mapping("test2")
    public AppxModel test2(){
        return appxMapper2.appx_get2(48);
    }

}

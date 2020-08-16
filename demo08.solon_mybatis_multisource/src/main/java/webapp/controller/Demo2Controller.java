package webapp.controller;

import org.noear.solon.annotation.XController;
import org.noear.solon.annotation.XMapping;
import org.noear.solon.extend.mybatis.Db;
import webapp.dso.mapper.Appx2Mapper;
import webapp.dso.mapper.AppxMapper;
import webapp.model.AppxModel;

/**
 * 注解模式，通过@Db注入，并指定具体的会话工厂
 *
 * @Df 可注入 Mapper, SqlSession, SqlSessionFactory, MybatisProxy
 * */
@XMapping("/demo2/")
@XController
public class Demo2Controller {
    @Db("db1")
    AppxMapper appxMapper;

    @Db("db2f")
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

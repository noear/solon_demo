package webapp.controller;

import org.apache.ibatis.session.SqlSession;
import org.noear.solon.annotation.XController;
import org.noear.solon.annotation.XInject;
import org.noear.solon.annotation.XMapping;
import org.noear.solon.annotation.XSingleton;
import webapp.dso.db.AppxMapper;
import webapp.model.AppxModel;

@XMapping("/test")
@XSingleton(true)
@XController
public class TestController {

    @XInject
    SqlSession sqlSession;

    @XInject("sqlSession2")
    SqlSession sqlSession2;

    @XMapping("demo1")
    public Object test1() throws Exception{
        AppxMapper mapper = sqlSession.getMapper(AppxMapper.class);

        AppxModel tmp = mapper.appx_get();

        return tmp;
    }

    @XMapping("demo2")
    public Object test2() throws Exception{
        AppxMapper mapper = sqlSession.getMapper(AppxMapper.class);

        AppxModel tmp = mapper.appx_get2(48);

        return tmp;
    }


    @XMapping("demo11")
    public Object test11() throws Exception{
        AppxMapper mapper = sqlSession2.getMapper(AppxMapper.class);

        AppxModel tmp = mapper.appx_get();

        return tmp;
    }

    @XMapping("demo12")
    public Object test12() throws Exception{
        AppxMapper mapper = sqlSession2.getMapper(AppxMapper.class);

        AppxModel tmp = mapper.appx_get2(48);

        return tmp;
    }

}

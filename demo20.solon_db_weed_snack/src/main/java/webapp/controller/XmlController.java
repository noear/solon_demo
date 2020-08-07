package webapp.controller;

import org.noear.solon.annotation.XController;
import org.noear.solon.annotation.XInject;
import org.noear.solon.annotation.XMapping;
import org.noear.solon.annotation.XSingleton;
import org.noear.solon.core.ModelAndView;
import webapp.dso.mapper.SqlMapper;


@XMapping("/xml")
@XSingleton(true)
@XController
public class XmlController {

    @XInject
    SqlMapper sqlMapper;


    @XMapping("demo0/html")
    public ModelAndView demo0() throws Exception {
        ModelAndView mv = new ModelAndView("view.ftl");


        //
        // 直接通过 call @{namespace}.{id} 调用
        //
        Object _map = sqlMapper.appx_get3("appx", 48);

        return mv;
    }


    @XMapping("demo1/json")
    public Object demo1() throws Exception {
        return sqlMapper.appx_get();
    }

    @XMapping("demo2/json")
    public Object demo2() throws Exception {
        return sqlMapper.appx_get2(48);
    }

    @XMapping("demo3/json")
    public Object demo3() throws Exception {
        return sqlMapper.appx_get3("appx", 48);
    }

    @XMapping("demo4/json")
    public Object demo4() throws Exception {
        return sqlMapper.appx_getlist(1);
    }

    @XMapping("demo5/json")
    public Object demo5() throws Exception {
        return sqlMapper.appx_getids();
    }
}

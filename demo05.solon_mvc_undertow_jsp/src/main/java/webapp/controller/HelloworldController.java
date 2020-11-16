package webapp.controller;

import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Inject;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.core.handler.Context;
import org.noear.solon.core.handler.ModelAndView;
import webapp.model.UserModel;

@Controller
public class HelloworldController {

    //这里注入个配置
    @Inject("${custom.user}")
    protected String user;

    @Mapping("/helloworld")
    public ModelAndView helloworld(Context ctx){
        UserModel m = new UserModel();
        m.setId(10);
        m.setName("刘之西东");
        m.setSex(1);

        ModelAndView vm = new ModelAndView("helloworld.jsp");

        vm.put("title","demo");
        vm.put("message","hello world!");

        vm.put("m",m);

        vm.put("user", user);

        vm.put("ctx",ctx);

        return vm;
    }
}

package webapp.controller;

import org.beetl.sql.solon.annotation.Db;
import org.noear.snack.ONode;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.core.handle.ModelAndView;
import webapp.dso.dao.UserMapper;
import webapp.model.SysUserModel;

@Controller
public class HelloworldController {
    @Db
    UserMapper mapper;

    @Mapping("/helloworld")
    public Object helloworld(){
        SysUserModel m = new SysUserModel();
        m.setId(10L);
        m.setName("刘之西东");
        m.setDepartmentId(1);

        ModelAndView vm = new ModelAndView("helloworld.htm");

        vm.put("title","demo");
        vm.put("message","hello world!");
        vm.put("m",m);
        vm.put("user", ONode.stringify(mapper.userSelect()));

        return vm;
    }
}

package webapp.controller;

import org.noear.solon.annotation.XController;
import org.noear.solon.annotation.XMapping;
import org.noear.solon.core.ModelAndView;
import webapp.model.SysUserModel;

@XController
public class HelloworldController {
    @XMapping("/helloworld")
    public Object helloworld(){
        SysUserModel m = new SysUserModel();
        m.setId(10);
        m.setName("刘之西东");
        m.setDepartmentId(1);

        ModelAndView vm = new ModelAndView("helloworld.htm");

        vm.put("title","demo");
        vm.put("message","hello world!");
        vm.put("m",m);

        return vm;
    }
}

package webapp.controller;

import org.noear.solon.annotation.XController;
import org.noear.solon.annotation.XMapping;
import org.noear.solon.core.ModelAndView;
import webapp.model.UserModel;

@XController
public class HelloworldController {
    @XMapping("/helloworld")
    public Object helloworld(){
        UserModel m = new UserModel();
        m.setId(10);
        m.setName("刘之西东");
        m.setSex(1);

        ModelAndView vm = new ModelAndView("helloworld.shtm");

        vm.put("title","demo");
        vm.put("message","hello world!");
        vm.put("m",m);

        return vm;
    }
}

package dockapp_http.controller;

import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.core.handle.ModelAndView;

@Controller
public class HomeController {
    @Mapping("/")
    public String hello(){
        return "Hello world!";
    }


    @Mapping("/b.ftl")
    public Object view(){
        return new ModelAndView("b.ftl");
    }
}

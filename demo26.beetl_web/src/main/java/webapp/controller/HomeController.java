package webapp.controller;

import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;

@Controller
public class HomeController {
    @Mapping(value = "/", produces = "text/html;charset=utf-8")
    public String home(){
        return "<a href='/helloworld'>/helloworld::html</a> <br/> <a href='/dao/'>/dao/::json</a>";
    }
}

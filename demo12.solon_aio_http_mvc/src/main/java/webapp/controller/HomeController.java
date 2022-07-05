package webapp.controller;

import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.annotation.Produces;

@Controller
public class HomeController {
    @Produces("text/html;charset=utf-8")
    @Mapping("/")
    public String home(){
        return "<a href='/helloworld'>/helloworld</a>";
    }
}

package webapp.controller;

import org.noear.solon.annotation.XController;
import org.noear.solon.annotation.XMapping;

@XController
public class HomeController {
    @XMapping(value = "/", produces = "text/html;charset=utf-8")
    public String home(){
        return "<a href='/helloworld'>/helloworld</a> <a href='/dao/'>/dao/</a>";
    }
}

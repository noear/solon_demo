package dockapp_http.controller;

import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;

@Controller
public class HomeController {
    @Mapping("/")
    public String hello(){
        return "Hello world!";
    }
}

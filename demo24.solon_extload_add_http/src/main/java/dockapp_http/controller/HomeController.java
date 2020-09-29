package dockapp_http.controller;

import org.noear.solon.annotation.XController;
import org.noear.solon.annotation.XMapping;

@XController
public class HomeController {
    @XMapping("/")
    public String hello(){
        return "Hello world!";
    }
}

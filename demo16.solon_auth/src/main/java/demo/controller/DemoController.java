package demo.controller;

import demo.dso.auth.Auth;
import static demo.dso.auth.AuthRole.*;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.extend.validation.annotation.Valid;

/**
 * @author noear 2021/3/10 created
 */
@Valid //这个可以注解在基类上
@Controller
public class DemoController {

    @Auth({SYSTEM, ORG_ADMIN})
    @Mapping("/test1")
    public String test1() {
        return "OK";
    }

    @Auth({ANYONE})
    @Mapping("/test2")
    public String test2() {
        return "OK";
    }
}

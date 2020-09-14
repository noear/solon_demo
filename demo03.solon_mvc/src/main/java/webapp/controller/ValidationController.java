package webapp.controller;

import org.noear.solon.annotation.XController;
import org.noear.solon.annotation.XMapping;
import org.noear.solon.extend.validation.annotation.*;

@XValid  //为控制器开启校验能力；也可以做用在一个基类上
@XController
public class ValidationController {

    @NoRepeatSubmit
    @NotNull({"name", "icon", "mobile"})
    @XMapping("/valid")
    public String test(String name, String icon, @Pattern("13\\d{9}") String mobile) {
        return "OK";
    }

    @Whitelist
    @XMapping("/valid/test2")
    public String test2() {
        return "OK";
    }
}

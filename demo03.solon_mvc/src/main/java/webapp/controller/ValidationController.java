package webapp.controller;

import lombok.NonNull;
import org.noear.solon.annotation.XController;
import org.noear.solon.annotation.XMapping;
import org.noear.solon.extend.validation.annotation.NoRepeatSubmit;
import org.noear.solon.extend.validation.annotation.NotNull;
import org.noear.solon.extend.validation.annotation.Pattern;
import org.noear.solon.extend.validation.annotation.XValid;

@XValid  //为控制器开启校验能力；也可以做用在一个基类上
@XController
public class ValidationController {

    @NoRepeatSubmit
    @NotNull({"name", "icon", "mobile"})
    @XMapping("/valid")
    public void test(String name, String icon, @Pattern("13\\d{9}") String mobile) {

    }
}

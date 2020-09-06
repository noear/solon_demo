package webapp.controller;

import org.noear.solon.annotation.XController;
import org.noear.solon.annotation.XMapping;
import org.noear.solon.extend.validation.annotation.NotNull;
import org.noear.solon.extend.validation.annotation.XValid;

@XValid
@XController
public class ValidationController {

    @NotNull({"name"})
    @XMapping("/valid")
    public void test(String name){

    }
}

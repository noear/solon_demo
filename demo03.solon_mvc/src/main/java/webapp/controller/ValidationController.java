package webapp.controller;

import org.noear.solon.annotation.XController;
import org.noear.solon.annotation.XMapping;
import org.noear.solon.extend.validation.ValidateController;
import org.noear.solon.extend.validation.annotation.NotNull;

@XController
public class ValidationController extends ValidateController {

    @NotNull({"name"})
    @XMapping("/valid")
    public void test(String name){

    }
}

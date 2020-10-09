package webapp.controller;

import org.noear.solon.annotation.XController;
import org.noear.solon.annotation.XMapping;
import org.noear.solon.core.XContext;

@XController
public class JumpController {

    @XMapping("/jump/")
    public void jump(XContext ctx) {
        ctx.redirect("http://www.noear.org");
    }
}

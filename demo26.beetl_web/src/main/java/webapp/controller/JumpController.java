package webapp.controller;

import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.core.XContext;

@Controller
public class JumpController {

    @Mapping("/jump/")
    public void jump(XContext ctx) {
        ctx.redirect("http://www.noear.org");
    }
}

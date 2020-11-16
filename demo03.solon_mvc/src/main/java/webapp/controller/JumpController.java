package webapp.controller;

import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.core.handler.Context;

@Controller
public class JumpController {

    @Mapping("/jump/")
    public void jump(Context ctx) {
        ctx.redirect("http://www.noear.org");
    }
}

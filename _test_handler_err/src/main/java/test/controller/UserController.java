package test.controller;

import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.core.handle.Context;
import org.noear.solon.core.handle.Result;

/**
 * @author noear 2021/8/8 created
 */
@Mapping("/user/")
@Controller
public class UserController {
    @Mapping("add")
    public Object add(Context ctx){
        System.out.println(ctx.method() +"...ADD");

        return Result.succeed();
    }
}

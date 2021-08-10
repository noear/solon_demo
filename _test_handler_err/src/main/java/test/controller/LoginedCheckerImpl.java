package test.controller;

import org.noear.solon.Utils;
import org.noear.solon.annotation.Component;
import org.noear.solon.core.handle.Context;
import org.noear.solon.validation.annotation.Logined;
import org.noear.solon.validation.annotation.LoginedChecker;

/**
 * @author noear 2021/8/8 created
 */
@Component
public class LoginedCheckerImpl implements LoginedChecker {
    @Override
    public boolean check(Logined anno, Context ctx, String userKeyName) {
        String user_id = ctx.session("user_id", "");
        if (Utils.isEmpty(user_id)) {
            return false;
        } else {
            return true;
        }
    }
}

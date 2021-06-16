package demo.dso.auth;

import org.noear.solon.core.handle.Context;
import org.noear.solon.core.handle.Result;
import org.noear.solon.validation.Validator;

/**
 * @author noear 2021/3/10 created
 */
public class AuthValidator implements Validator<Auth> {
    public static final AuthValidator instance = new AuthValidator();

    @Override
    public String message(Auth anno) {
        return anno.message();
    }

    @Override
    public Result validateOfContext(Context ctx, Auth anno, String name, StringBuilder tmp) {
        int user_role = ctx.session("role", 0);

        for (AuthRole role : anno.value()) {
            if (user_role >= role.weight) {
                return Result.succeed();
            }
        }

        return Result.failure(401);
    }

}

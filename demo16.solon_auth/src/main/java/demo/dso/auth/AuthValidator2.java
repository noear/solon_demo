package demo.dso.auth;

import org.noear.solon.core.handle.Context;
import org.noear.solon.core.handle.Result;
import org.noear.solon.extend.validation.Validator;

/**
 * 尝试不同的输出效果
 *
 * @author noear 2021/3/10 created
 */
public class AuthValidator2 implements Validator<Auth> {
    public static final AuthValidator2 instance = new AuthValidator2();

    @Override
    public String message(Auth anno) {
        return anno.message();
    }

    @Override
    public Result validate(Context ctx, Auth anno, String name, StringBuilder tmp) {
        int user_role = ctx.session("role", 0);

        for (AuthRole role : anno.value()) {
            if (user_role >= role.weight) {
                return Result.succeed();
            }
        }

        //将宣染状态设为已宣染（后续只输出http status，不输出内容）
        ctx.setRendered(true);

        return Result.failure(401);
    }
}

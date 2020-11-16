package webapp.dso;

import org.noear.solon.core.handler.Context;
import org.noear.solon.core.handler.Result;
import org.noear.solon.extend.validation.annotation.Whitelist;
import org.noear.solon.extend.validation.annotation.WhitelistValidator;

public class WhitelistValidatorImpl extends WhitelistValidator {
    @Override
    public Result validate(Context ctx, Whitelist anno, String name, StringBuilder tmp) {
        System.out.println("成功定制...");

        return Result.failure();
    }
}

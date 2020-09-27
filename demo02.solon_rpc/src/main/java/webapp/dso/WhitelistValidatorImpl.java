package webapp.dso;

import org.noear.solon.core.XContext;
import org.noear.solon.core.XResult;
import org.noear.solon.extend.validation.annotation.Whitelist;
import org.noear.solon.extend.validation.annotation.WhitelistValidator;

public class WhitelistValidatorImpl extends WhitelistValidator {
    @Override
    public XResult validate(XContext ctx, Whitelist anno, String name, StringBuilder tmp) {
        System.out.println("成功定制...");

        return XResult.failure();
    }
}

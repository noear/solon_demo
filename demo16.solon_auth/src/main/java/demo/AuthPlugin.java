package demo;


import demo.dso.auth.Auth;
import demo.dso.auth.AuthValidator;
import org.noear.solon.SolonApp;
import org.noear.solon.annotation.Component;
import org.noear.solon.core.Plugin;
import org.noear.solon.core.handle.Context;
import org.noear.solon.core.handle.Result;
import org.noear.solon.extend.validation.ValidatorFailureHandler;
import org.noear.solon.extend.validation.ValidatorManager;

import java.lang.annotation.Annotation;

/**
 * @author noear 2021/3/10 created
 */
@Component
public class AuthPlugin implements Plugin {
    @Override
    public void start(SolonApp app) {
        ValidatorManager.global().register(Auth.class, AuthValidator.instance);

        //如果想定义错误信息（可参考默认的实现：ValidatorFailureHandlerImp ）
        ValidatorManager.global().onFailure(new ValidatorFailureHandler() {
            @Override
            public boolean onFailure(Context ctx, Annotation ano, Result result, String message) {
                return false;
            }
        });
    }
}

package demo;


import demo.dso.auth.Auth;
import demo.dso.auth.AuthValidator;
import org.noear.solon.SolonApp;
import org.noear.solon.annotation.Component;
import org.noear.solon.core.Plugin;
import org.noear.solon.extend.validation.ValidatorManager;

/**
 * @author noear 2021/3/10 created
 */
@Component
public class AuthPlugin implements Plugin {
    @Override
    public void start(SolonApp app) {
        ValidatorManager.global().register(Auth.class, AuthValidator.instance);
    }
}

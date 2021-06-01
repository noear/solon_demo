package demo;

import demo.dso.AuthProcessorImpl;
import org.noear.snack.ONode;
import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Configuration;
import org.noear.solon.extend.auth.AuthAdapter;
import org.noear.solon.extend.auth.AuthInterceptorLogined;

/**
 * @author noear 2021/6/1 created
 */
@Configuration
public class Config {
    @Bean
    public AuthAdapter init() {
        return new AuthAdapter()
                .loginUrl("/login")
                .authPathMatchers((ctx, path) -> {
                    if (path.startsWith("/login") || ctx.action() == null) {
                        return false;
                    } else {
                        return true;
                    }
                })
                .authInterceptor(new AuthInterceptorLogined())
                .authProcessor(new AuthProcessorImpl())
                .authOnFailure((ctx, rst) -> {
                    ctx.outputAsJson(new ONode().set("code", 403).set("msg", "没有权限").toJson());
                });
    }
}

package demo;

import demo.dso.AuthProcessorImpl;
import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Configuration;
import org.noear.solon.extend.auth.AuthAdapter;

/**
 * @author noear 2021/6/1 created
 */
@Configuration
public class Config {
    @Bean
    public AuthAdapter init() {
        return new AuthAdapter()
                .loginUrl("/login") //设定登录地址，未登录时自动跳转
                .addRule(r -> r.include("**").verifyIp().failure((c, t) -> c.output("你的IP不在白名单")))
                .addRule(b -> b.include("/rock/**").verifyPath())
                .processor(new AuthProcessorImpl()) //设定认证处理器
                .failure((ctx, rst) -> { //设定验证失败代理
                    ctx.render(rst);
                });
    }
}

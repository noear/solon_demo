package test;

import org.noear.solon.Solon;
import org.noear.solon.core.handle.Context;
import org.noear.solon.web.cors.CrossHandler;
import test.dso.CrossHandlerNew;

/**
 * @author noear 2021/8/8 created
 */
public class App1 {
    public static void main(String[] args) {
        Solon.start(App1.class, args, app -> {
            app.before(c->{
                System.out.println(c.method() +" " +c.path());
            });

            app.before(new CrossHandlerNew()
                    .allowCredentials(true)
                    .allowMethods("*")
                    .allowHeaders("*")
                    .allowOrigin("*"));
        });
    }
}

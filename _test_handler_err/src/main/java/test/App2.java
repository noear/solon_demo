package test;

import org.noear.solon.Solon;
import org.noear.solon.core.handle.Context;
import org.noear.solon.web.cors.CrossHandler;
import test.dso.CrossHandlerNew;

/**
 * @author noear 2021/8/8 created
 */
public class App2 {
    public static void main(String[] args) {
        Solon.start(App2.class, args, app -> {
            app.before(new CrossHandler().allowedOrigins("*"));
        });
    }
}

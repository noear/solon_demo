package test;

import org.noear.solon.Solon;
import org.noear.solon.core.handle.Context;
import org.noear.solon.extend.cors.CrossHandler;
import test.dso.CrossHandlerNew;

/**
 * @author noear 2021/8/8 created
 */
public class App2 {
    public static void main(String[] args) {
        Solon.start(App2.class, args, app -> {
            app.before(new CrossHandler().allowedOrigins("*"));
        }).onError(e -> {
            if (Solon.cfg().isDebugMode() || Solon.cfg().isFilesMode()) {
                e.printStackTrace();
            }

            Context ctx = Context.current();

            if (ctx != null) {
                ctx.output("出错了"); //后面还会有异常输出
            }
        });
    }
}

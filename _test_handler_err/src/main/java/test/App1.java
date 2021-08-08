package test;

import org.noear.solon.Solon;
import org.noear.solon.core.handle.Context;

/**
 * @author noear 2021/8/8 created
 */
public class App1 {
    public static void main(String[] args) {
        Solon.start(App1.class, args).onError(e -> {
            if(Solon.cfg().isDebugMode() || Solon.cfg().isFilesMode()) {
                e.printStackTrace();
            }

            Context ctx = Context.current();

            if (ctx != null) {
                if (ctx.getRendered() == false) {
                    ctx.output("出错了");  //后面不会有异常输出
                }

                ctx.setHandled(true);
                ctx.setRendered(true);
            }
        });
    }
}

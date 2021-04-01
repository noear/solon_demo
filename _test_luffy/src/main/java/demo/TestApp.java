package demo;

import org.noear.luffy.dso.CallUtil;
import org.noear.luffy.dso.JtFun;
import org.noear.solon.Solon;
import org.noear.solon.SolonApp;
import org.noear.solon.extend.luffy.LuffyHandler;

/**
 * @author noear 2021/3/28 created
 */
public class TestApp {
    public static void main(String[] args) {
        SolonApp app = Solon.start(TestApp.class, args);

        app.all("**", new LuffyHandler());

        //CallUtil.callFile("/hello.js", null);
    }
}

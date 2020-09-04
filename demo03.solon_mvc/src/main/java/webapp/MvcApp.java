package webapp;

import org.noear.solon.XApp;
import org.noear.solon.extend.data.annotation.EnableCaching;

@EnableCaching
public class MvcApp {
    public static void main(String[] args) {
        XApp.start(MvcApp.class, args);
    }
}

package webapp.server;

import org.noear.solon.XApp;
import org.noear.solon.extend.dubbo.EnableDubbo;

@EnableDubbo
public class DubboProviderApp {
    public static void main(String[] args) {
        XApp.start(DubboProviderApp.class, args);
    }
}

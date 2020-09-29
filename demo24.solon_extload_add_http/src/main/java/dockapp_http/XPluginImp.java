package dockapp_http;

import org.noear.solon.XApp;
import org.noear.solon.core.XPlugin;

public class XPluginImp implements XPlugin {
    @Override
    public void start(XApp app) {
//        app.get("/",x->x.output("Hello world!"));
        app.beanScan(XPluginImp.class);
    }
}

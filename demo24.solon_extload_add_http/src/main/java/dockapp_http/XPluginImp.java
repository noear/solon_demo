package dockapp_http;

import org.noear.solon.XApp;
import org.noear.solon.core.XPlugin;

public class XPluginImp implements XPlugin {
    @Override
    public void start(XApp app) {
        //扫描出控制器
        app.beanScan(XPluginImp.class);

        //如果只有一个类，可用beanMake（快）
        //app.beanMake(HomeController.class);

        //如果随便玩玩，也可用handler风格
        //app.get("/",x->x.output("Hello world!"));
    }
}

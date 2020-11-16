package dockapp_http;

import org.noear.solon.Solon;
import org.noear.solon.SolonApp;
import org.noear.solon.core.Plugin;

public class XPluginImp implements Plugin {
    @Override
    public void start(SolonApp app) {
        //扫描出控制器
        app.beanScan(XPluginImp.class);

        //如果只有一个类，可用beanMake（快）
        //app.beanMake(HomeController.class);

        //如果随便玩玩，也可用handler风格
        //app.get("/",x->x.output("Hello world!"));

        System.out.println("我是个体外扩展包，我让你能玩http了");
        System.out.println("用浏览器打开：http://localhost:8080/");
    }
}

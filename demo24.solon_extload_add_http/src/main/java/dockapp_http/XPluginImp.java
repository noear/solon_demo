package dockapp_http;

import org.noear.solon.XApp;
import org.noear.solon.core.XPlugin;

public class XPluginImp implements XPlugin {
    @Override
    public void start(XApp app) {
        //扫描出控制器
        app.loadBean(XPluginImp.class); //以后会更名为：beanScan

        //如果只有一个类，可用beanMake（快）
        //app.makeBean(HomeController.class); //以后会更名为：beanMake

        //如果随便玩玩，也可用handler风格
        //app.get("/",x->x.output("Hello world!"));

        System.out.println("我是个体外扩展包，我让你能玩http了");
        System.out.println("用浏览器打开：http://localhost:8080/");
    }
}

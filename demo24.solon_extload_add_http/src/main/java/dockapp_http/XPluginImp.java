package dockapp_http;

import org.noear.solon.core.AopContext;
import org.noear.solon.core.Plugin;
import org.noear.solon.i18n.I18nUtil;

import java.util.Locale;

public class XPluginImp implements Plugin {
    @Override
    public void start(AopContext context) {
        //扫描出控制器
        context.beanScan(XPluginImp.class);

        //如果只有一个类，可用beanMake（快）
        //context.beanMake(HomeController.class);

        //如果随便玩玩，也可用handler风格
        //context.get("/",x->x.output("Hello world!"));


        System.out.println("我是个体外扩展包，我让你能玩http了");
        System.out.println("用浏览器打开：http://localhost:8080/");

        System.out.println("i18n::" + I18nUtil.getMessage(Locale.getDefault(), "user.name"));
    }
}

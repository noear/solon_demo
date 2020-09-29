package dockapp_actuator;

import org.noear.solon.XApp;
import org.noear.solon.core.Aop;
import org.noear.solon.core.XPlugin;

public class XPluginImp implements XPlugin {
    @Override
    public void start(XApp app) {

        //loadBean，会扫描文夹；
        //app.loadBean(XPluginImp.class);

        //makeBean，会直接处理类
        app.beanMake(Actuator1.class);
    }
}

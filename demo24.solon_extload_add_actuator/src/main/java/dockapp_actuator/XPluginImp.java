package dockapp_actuator;

import org.noear.solon.XApp;
import org.noear.solon.core.XPlugin;

public class XPluginImp implements XPlugin {
    @Override
    public void start(XApp app) {

        //beanScan，会扫描包下所有类文件并处理（范围广，慢）；
        //app.loadBean(XPluginImp.class); //以后改名为：beanScan

        //makeBean，会直接处理类（快）
        app.makeBean(Actuator1.class);
    }
}

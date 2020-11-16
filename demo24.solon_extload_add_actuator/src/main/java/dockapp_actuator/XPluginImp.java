package dockapp_actuator;

import org.noear.solon.SolonApp;
import org.noear.solon.core.Plugin;

public class XPluginImp implements Plugin {
    @Override
    public void start(SolonApp app) {

        //beanScan，会扫描包下所有类文件并处理（范围广，慢）；
        //app.beanScan(PluginImp.class);

        //beanMake，会直接处理类（快）
        app.beanMake(Actuator1.class);
    }
}

package dockapp_actuator;

import org.noear.solon.core.AopContext;
import org.noear.solon.core.Plugin;

public class XPluginImp implements Plugin {
    @Override
    public void start(AopContext context) {

        //beanScan，会扫描包下所有类文件并处理（范围广，慢）；
        //context.beanScan(PluginImp.class);

        //beanMake，会直接处理类（快）
        context.beanMake(Actuator1.class);
    }
}

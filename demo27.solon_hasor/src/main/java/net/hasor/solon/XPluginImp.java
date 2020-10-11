package net.hasor.solon;

import net.hasor.core.DimModule;
import net.hasor.core.Module;
import net.hasor.solon.beans.BuildConfig;
import org.noear.solon.XApp;
import org.noear.solon.core.Aop;
import org.noear.solon.core.XPlugin;

public class XPluginImp implements XPlugin {
    @Override
    public void start(XApp app) {
        //
        //注册bean构建器
        //
        Aop.context().beanBuilderAdd(DimModule.class, (type, bw, anno) -> {
            // 把Spring 中所有标记了 @DimModule 的 Module，捞进来。
            //
            if (Module.class.isAssignableFrom(type)) {
                BuildConfig.instance.loadModules.add(bw.raw());
            }
        });
    }
}

package net.hasor.solon.boot;

import net.hasor.core.AppContext;
import net.hasor.core.Module;
import net.hasor.utils.ExceptionUtils;
import net.hasor.utils.StringUtils;
import org.noear.solon.XApp;
import org.noear.solon.annotation.XConfiguration;
import org.noear.solon.core.Aop;
import org.noear.solon.core.XEventListener;
import org.noear.solon.event.BeanLoadedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * 将注解的配置转到 BuildConfig 实例上
 *
 * @author noear
 * @since 2020.10.10
 * */
@XConfiguration
public class HasorConfiguration implements XEventListener<BeanLoadedEvent> {
    private static Logger logger = LoggerFactory.getLogger(HasorConfiguration.class);

    public HasorConfiguration() {
        this(XApp.global().source().getAnnotation(EnableHasor.class));
    }

    /**
     * 此构建函数，是为了手动写代码提供支持；充许EnableHasor注在别的临时类上实现配置
     * <p>
     * 为开发隐式插件提供支持
     */
    public HasorConfiguration(EnableHasor enableHasor) {
        BuildConfig buildConfig = BuildConfig.getInstance();

        // 处理mainConfig
        buildConfig.mainConfig = enableHasor.mainConfig();

        // 处理useProperties
        buildConfig.useProperties = enableHasor.useProperties();

        // 处理startWith
        for (Class<? extends Module> startWith : enableHasor.startWith()) {
            buildConfig.addModules(Aop.get(startWith));
        }

        // 把Solon 中所有标记了 @DimModule 的 Module，捞进来。 //交给XPluginImp处理

        //
        // 处理scanPackages
        if (enableHasor.scanPackages().length != 0) {
            for (String p : enableHasor.scanPackages()) {
                if (p.endsWith(".*")) {
                    XApp.global().beanScan(p.substring(0, p.length() - 2));
                } else {
                    XApp.global().beanScan(p);
                }
            }
        }

        // 处理customProperties
        Property[] customProperties = enableHasor.customProperties();
        for (Property property : customProperties) {
            String name = property.name();
            if (StringUtils.isNotBlank(name)) {
                buildConfig.customProperties.put(name, property.value());
            }
        }
    }

    @Override
    public void onEvent(BeanLoadedEvent beanLoadedEvent) {
        //没有EnableHasorWeb时，生成AppContext并注入容器
        //
        if (XApp.global().source().getAnnotation(EnableHasorWeb.class) == null) {
            //所有bean加载完成之后，手动注入AppContext
            Aop.wrapAndPut(AppContext.class, initAppContext());
        }
    }

    private AppContext initAppContext() {
        try {
            return BuildConfig.getInstance().build(null);
        } catch (IOException e) {
            throw ExceptionUtils.toRuntimeException(e);
        }
    }
}

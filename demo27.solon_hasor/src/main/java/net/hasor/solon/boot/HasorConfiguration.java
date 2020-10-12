package net.hasor.solon.boot;

import net.hasor.core.Module;
import net.hasor.utils.ResourcesUtils;
import net.hasor.utils.StringUtils;
import net.hasor.utils.io.IOUtils;
import org.noear.solon.XApp;
import org.noear.solon.annotation.XConfiguration;
import org.noear.solon.core.Aop;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.*;

/**
 * @author noear
 * @since 2020.10.10
 * */
@XConfiguration
public class HasorConfiguration {
    private static Logger logger = LoggerFactory.getLogger(HasorConfiguration.class);

    public HasorConfiguration() {
        BuildConfig buildConfig = BuildConfig.getInstance();

        // 得到 EnableHasor
        EnableHasor enableHasor = XApp.global().source().getAnnotation(EnableHasor.class);

        // 处理mainConfig
        buildConfig.mainConfig = enableHasor.mainConfig();

        // 处理useProperties
        buildConfig.useProperties = enableHasor.useProperties();

        // 处理startWith
        for (Class<? extends Module> startWith : enableHasor.startWith()) {
            buildConfig.loadModules.add(Aop.get(startWith));
        }

        // 把Spring 中所有标记了 @DimModule 的 Module，捞进来。 //交给XPluginImp处理

        //
        // 处理scanPackages
        if (enableHasor.scanPackages().length != 0) {
            for (String p : enableHasor.scanPackages()) {
                XApp.global().beanScan(p);
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

        //
        // .打印 Hello
        printLogo();
    }

    private void printLogo() {
        try {
            InputStream inputStream = ResourcesUtils.getResourceAsStream("/META-INF/hasor-framework/hasor-spring-hello.txt");
            List<String> helloText = IOUtils.readLines(inputStream, "utf-8");
            StringBuilder builder = new StringBuilder("\n");
            for (String msg : helloText) {
                builder.append(msg).append("\n");
            }
            logger.info(builder.toString());
        } catch (Exception e) { /**/ }
    }
}

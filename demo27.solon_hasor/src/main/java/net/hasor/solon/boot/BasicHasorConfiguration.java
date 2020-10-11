package net.hasor.solon.boot;

import net.hasor.core.AppContext;
import net.hasor.core.Module;
import net.hasor.solon.beans.BaseConfiguration;
import net.hasor.solon.beans.BuildConfig;
import net.hasor.utils.ExceptionUtils;
import net.hasor.utils.ResourcesUtils;
import net.hasor.utils.StringUtils;
import net.hasor.utils.io.IOUtils;
import org.noear.solon.XApp;
import org.noear.solon.annotation.XBean;
import org.noear.solon.annotation.XConfiguration;
import org.noear.solon.core.Aop;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.util.*;

@XConfiguration
public class BasicHasorConfiguration extends BaseConfiguration {
    private static Logger logger = LoggerFactory.getLogger(BasicHasorConfiguration.class);

    @XBean
    public void init() {
        BuildConfig buildConfig = getBuildConfig();

        // 得到 EnableHasor
        EnableHasor enableHasor = XApp.global().source().getAnnotation(EnableHasor.class);

        // 处理mainConfig
        buildConfig.mainConfig = enableHasor.mainConfig();
        // 处理useProperties
        buildConfig.useProperties = enableHasor.useProperties();
        // 处理startWith
        for (Class<? extends Module> startWith : enableHasor.startWith()) {
            boolean useSpring = false;
            Annotation[] interfaces = startWith.getAnnotations();
            for (Annotation annotatedType : interfaces) {
                if (annotatedType instanceof XBean) {
                    useSpring = true;
                    break;
                }
                if (annotatedType.annotationType().getAnnotation(XBean.class) != null) {
                    useSpring = true;
                    break;
                }
            }
            if (useSpring) {
                buildConfig.loadModules.add(Aop.get(startWith));
            } else {
                try {
                    buildConfig.loadModules.add(startWith.newInstance());
                } catch (Exception e) {
                    throw ExceptionUtils.toRuntimeException(e);
                }
            }
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
        try {
            InputStream inputStream = ResourcesUtils.getResourceAsStream("/META-INF/hasor-framework/hasor-spring-hello.txt");
            List<String> helloText = IOUtils.readLines(inputStream, "utf-8");
            StringBuilder builder = new StringBuilder("\n");
            for (String msg : helloText) {
                builder.append(msg).append("\n");
            }
            logger.info(builder.toString());
        } catch (Exception e) { /**/ }
        //
    }


    @XBean
    public AppContext appContext() {
        ServletContext parent = Aop.getOrNull(ServletContext.class);
        //如果不为null，则为web
        return this.createAppContext(parent);
    }

    protected AppContext createAppContext(Object parentObject) {
        try {
            return this.getBuildConfig().build(parentObject).build(apiBinder -> {
                //apiBinder.bindType(ApplicationContext.class).toInstance(applicationContext);
            });
        } catch (IOException e) {
            throw ExceptionUtils.toRuntimeException(e);
        }
    }
}

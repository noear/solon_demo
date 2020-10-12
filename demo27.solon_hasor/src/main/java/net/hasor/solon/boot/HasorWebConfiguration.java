package net.hasor.solon.boot;

import net.hasor.core.AppContext;
import net.hasor.solon.beans.BaseConfiguration;
import net.hasor.utils.ExceptionUtils;
import net.hasor.web.startup.RuntimeFilter;
import net.hasor.web.startup.RuntimeListener;
import org.noear.solon.XApp;
import org.noear.solon.annotation.XConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;
import java.util.EnumSet;
import java.util.Set;

@XConfiguration
public class HasorWebConfiguration extends BaseConfiguration implements ServletContainerInitializer {
    private static final Logger logger = LoggerFactory.getLogger(HasorWebConfiguration.class);
    private String filterPath = "/*";
    private int filterOrder = 0;

    public HasorWebConfiguration(){
        // 得到 EnableHasorWeb
        EnableHasorWeb enableHasor = XApp.global().source().getAnnotation(EnableHasorWeb.class);
        //
        this.filterPath = enableHasor.path();
        this.filterOrder = 0;
        //
        logger.info("@EnableHasorWeb -> filterPath='" + this.filterPath + "', filterOrder='" + this.filterOrder);

    }

    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {
        AppContext appContext = initAppContext(servletContext);

        //注册 listener
        RuntimeListener listener = new RuntimeListener(appContext);
        servletContext.addListener(listener);

        //注册 filter
        Filter filter = new RuntimeFilter(appContext);
        servletContext.addFilter("runtimeFilter", filter)
                .addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, this.filterPath);
    }

    private AppContext initAppContext(ServletContext servletContext) {
        try {
            return this.getBuildConfig().build(servletContext).build();
        } catch (IOException e) {
            throw ExceptionUtils.toRuntimeException(e);
        }
    }
}

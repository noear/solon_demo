package net.hasor.solon.boot;

import net.hasor.core.AppContext;
import net.hasor.solon.beans.BaseConfiguration;
import net.hasor.utils.ExceptionUtils;
import net.hasor.web.binder.OneConfig;
import net.hasor.web.startup.RuntimeFilter;
import net.hasor.web.startup.RuntimeListener;
import org.noear.solon.XApp;
import org.noear.solon.annotation.XBean;
import org.noear.solon.annotation.XConfiguration;
import org.noear.solon.annotation.XInject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.EventListener;

@XConfiguration
public class HasorWebConfiguration extends BaseConfiguration {
    private static final Logger logger = LoggerFactory.getLogger(HasorWebConfiguration.class);
    private String filterPath = "/*";
    private int filterOrder = 0;


    @XBean
    public void init() {
        // 得到 EnableHasorWeb
        EnableHasorWeb enableHasor = XApp.global().source().getAnnotation(EnableHasorWeb.class);
        //
        this.filterPath = enableHasor.path();
        this.filterOrder = 0;
        //
        logger.info("@EnableHasorWeb -> filterPath='" + this.filterPath + "', filterOrder='" + this.filterOrder);
    }

    @XBean
    public EventListener hasorRuntimeListener(@XInject AppContext appContext) {
        return new RuntimeListener(appContext);
    }

    /**
     * 拦截器模式下，添加Spring 拦截器
     */
    @XBean
    public void hasorInterceptors(@XInject AppContext appContext) {
        try {
            RuntimeFilter runtimeFilter = new RuntimeFilter(appContext);
            runtimeFilter.init(new OneConfig("", () -> appContext));

            Filter2Interceptor interceptor = new Filter2Interceptor(runtimeFilter);
            //
            String filterPath = this.filterPath;
            if (filterPath.endsWith("/*")) {
                filterPath = filterPath.substring(0, filterPath.length() - 2) + "/**";
            }

            XApp.global().before(filterPath, interceptor);
        } catch (Exception e) {
            throw ExceptionUtils.toRuntimeException(e);
        }
    }
}

package test.dso;

import org.noear.solon.Utils;
import org.noear.solon.core.handle.Context;
import org.noear.solon.core.handle.Handler;

/**
 * @author noear
 * @since 1.5
 */
public class CrossHandlerImpl implements Handler {
    protected int maxAge = 3600;

    protected String allowOrigin = "*";

    protected String allowMethods;
    protected String allowHeaders;
    protected boolean allowCredentials;


    public CrossHandlerImpl maxAge(int maxAge) {
        if (maxAge >= 0) {
            this.maxAge = maxAge;
        }

        return this;
    }

    public CrossHandlerImpl allowOrigin(String allowOrigin) {
        if (allowOrigin != null) {
            this.allowOrigin = allowOrigin;
        }

        return this;
    }

    public CrossHandlerImpl allowMethods(String allowMethods) {
        this.allowMethods = allowMethods;
        return this;
    }

    public CrossHandlerImpl allowHeaders(String allowHeaders) {
        this.allowHeaders = allowHeaders;
        return this;
    }

    public CrossHandlerImpl allowCredentials(boolean allowCredentials) {
        this.allowCredentials = allowCredentials;
        return this;
    }

    @Override
    public void handle(Context ctx) throws Throwable {
        String origin = ctx.header("Origin");

        if (Utils.isEmpty(origin)) {
            //如果没有 Origin 则不输出 Cross Header
            return;
        }

        //设定 max age
        ctx.headerSet("Access-Control-Max-Age", String.valueOf(maxAge));

        //设定 allow headers
        if (Utils.isNotEmpty(allowHeaders)) {
            if ("*".equals(allowHeaders)) {
                String requestHeaders = ctx.header("Access-Control-Request-Headers");

                if (Utils.isNotEmpty(requestHeaders)) {
                    ctx.headerSet("Access-Control-Allow-Headers", requestHeaders);
                }
            } else {
                ctx.headerSet("Access-Control-Allow-Headers", allowHeaders);
            }
        }

        //设定 allow methods
        if (Utils.isNotEmpty(allowMethods)) {
            if ("*".equals(allowMethods)) {
                String requestMethod = ctx.header("Access-Control-Request-Method");

                if (Utils.isEmpty(requestMethod)) {
                    requestMethod = ctx.method();
                }

                if (Utils.isNotEmpty(requestMethod)) {
                    ctx.headerSet("Access-Control-Allow-Methods", requestMethod);
                }
            } else {
                ctx.headerSet("Access-Control-Allow-Methods", allowMethods);
            }
        }

        //设定 allow origin
        if (allowCredentials) {
            ctx.headerSet("Access-Control-Allow-Credentials", "true");
            ctx.headerSet("Access-Control-Allow-Origin", origin);
        } else {
            ctx.headerSet("Access-Control-Allow-Origin", allowOrigin);
        }
    }
}

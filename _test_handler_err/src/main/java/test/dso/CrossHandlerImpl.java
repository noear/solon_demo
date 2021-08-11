package test.dso;

import org.noear.solon.Utils;
import org.noear.solon.core.handle.Context;
import org.noear.solon.core.handle.Handler;

import java.net.URI;

/**
 * @author noear 2021/8/11 created
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

        ctx.headerSet("Access-Control-Max-Age", String.valueOf(maxAge));

        if (Utils.isNotEmpty(allowHeaders)) {
            if ("*".equals(allowHeaders)) {
                ctx.headerSet("Access-Control-Allow-Headers", ctx.header("Access-Control-Request-Headers"));
            } else {
                ctx.headerSet("Access-Control-Allow-Headers", allowHeaders);
            }
        }

        if (Utils.isNotEmpty(allowMethods)) {
            if ("*".equals(allowMethods)) {
                ctx.headerSet("Access-Control-Allow-Methods", ctx.header("Access-Control-Request-Method"));
            } else {
                ctx.headerSet("Access-Control-Allow-Methods", allowMethods);
            }
        }

        if (allowCredentials) {
            ctx.headerSet("Access-Control-Allow-Credentials", "true");

            if ("*".equals(allowOrigin)) {
                String referer = ctx.header("Referer");
                if (Utils.isNotEmpty(referer)) {
                    URI uri = URI.create(referer);
                    String origin = uri.getScheme() +"://" + uri.getAuthority();
                    ctx.headerSet("Access-Control-Allow-Origin", origin);
                } else {
                    ctx.headerSet("Access-Control-Allow-Origin", allowOrigin);
                }
            } else {
                ctx.headerSet("Access-Control-Allow-Origin", allowOrigin);
            }
        } else {
            ctx.headerSet("Access-Control-Allow-Origin", allowOrigin);
        }
    }
}

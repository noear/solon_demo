package net.hasor.solon.boot;

import org.noear.solon.core.XContext;
import org.noear.solon.core.XHandler;

import javax.servlet.Filter;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.util.concurrent.atomic.AtomicBoolean;

public class Filter2Interceptor implements XHandler {
    private Filter filter;

    public Filter2Interceptor(Filter filter) {
        this.filter = filter;
    }

    @Override
    public void handle(XContext c) throws Throwable {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        filter.doFilter((ServletRequest) c.request(), (ServletResponse) c.response(), (request1, response1) -> {
            atomicBoolean.set(true);
        });

        if (atomicBoolean.get() == false) {
            c.setHandled(true);
        }
    }
}
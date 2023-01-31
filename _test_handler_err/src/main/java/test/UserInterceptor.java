package test;

import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.core.handle.Context;
import org.noear.solon.core.handle.Handler;

/**
 * @author noear 2021/8/8 created
 */
//@Mapping(value = "/user/**", before = true)
//@Controller
public class UserInterceptor implements Handler {
    @Override
    public void handle(Context ctx) throws Exception {
       // throw new NullPointerException();
    }
}

package webapp;

import net.hasor.web.startup.RuntimeFilter;
import net.hasor.web.startup.RuntimeListener;
import org.noear.solon.XApp;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class DataApp {
    public static void main(String[] args) throws Throwable {
        XApp app = XApp.start(DataApp.class, args);

//        RuntimeListener runtimeListener = new RuntimeListener();
//        RuntimeFilter runtimeFilter = new RuntimeFilter();
//
//        app.before("**", (c) -> {
//            runtimeFilter.doFilter((ServletRequest) c.request(), (ServletResponse) c.response(), (r, s) -> {
//            });
//        });
    }
}

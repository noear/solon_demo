package webapp.client;

import org.noear.solon.XApp;
import org.noear.solon.core.Aop;
import org.noear.solon.extend.dubbo.EnableDubbo;

@EnableDubbo
public class DemoDubboConsumeApp {
    public static void main(String[] args) {
        XApp.start(DemoDubboConsumeApp.class, args);

        HelloConsume tmp = Aop.get(HelloConsume.class);
        System.out.println(tmp.home());
    }
}

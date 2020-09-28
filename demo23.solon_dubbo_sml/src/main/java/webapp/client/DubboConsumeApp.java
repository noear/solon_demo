package webapp.client;

import org.apache.dubbo.config.annotation.Reference;
import org.noear.solon.XApp;
import org.noear.solon.annotation.XController;
import org.noear.solon.annotation.XMapping;
import org.noear.solon.core.Aop;
import org.noear.solon.extend.dubbo.EnableDubbo;
import webapp.protocol.HelloService;

@EnableDubbo
@XController
public class DubboConsumeApp {
    public static void main(String[] args) {
        XApp.start(DubboConsumeApp.class, args, app -> app.enableHttp(false));

        DubboConsumeApp tmp = Aop.get(DubboConsumeApp.class);
        System.out.println(tmp.home());
    }

    @Reference(group = "hello")
    HelloService helloService;

    @XMapping("/")
    public String home() {
        return helloService.sayHello("noear");
    }
}

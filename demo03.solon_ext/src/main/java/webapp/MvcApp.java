package webapp;

import org.noear.solon.Solon;

public class MvcApp {
    public static void main(String[] args) {
        Solon.start(MvcApp.class, args);

        System.out.println("读取配置 demo_name："+Solon.cfg().get("demo_name","1"));
    }
}

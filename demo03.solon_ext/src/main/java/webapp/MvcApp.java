package webapp;

import org.noear.solon.Solon;
import org.noear.solon.web.staticfiles.StaticMappings;
import org.noear.solon.web.staticfiles.repository.ExtendStaticRepository;

public class MvcApp {
    public static void main(String[] args) {

        Solon.start(MvcApp.class, args, app -> {
            StaticMappings.add("/", new ExtendStaticRepository());
        });

        System.out.println("读取配置 demo_name：" + Solon.cfg().get("demo_name", "1"));
    }
}

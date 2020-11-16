package webapp;

import org.noear.solon.Solon;

/**
 *
 * //资源路径说明（不用配置）
 * resources/application.properties（或 application.yml） 为应用配置文件
 * resources/static/ 为静态文件根目标
 * resources/WEB-INF/view/ 为视图文件根目标（支持多视图共存）
 *
 * */
public class UndertowMvcJspApp {
    public static void main(String[] args) {
        Solon.start(UndertowMvcJspApp.class, args);
    }
}

package demo;

import org.noear.solon.Solon;

/**
 * @author noear 2021/8/12 created
 */
public class App {
    public static void main(String[] args) {
        Solon.start(App.class, args, app -> {
            app.all("/", c -> c.output("hello: " + c.method()));
        });
    }
}

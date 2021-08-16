package demo;

import org.noear.solon.Solon;

import java.io.File;

/**
 * @author noear 2021/8/12 created
 */
public class App {
    public static void main(String[] args) {
        Solon.start(App.class, args, app -> {
            app.all("/", c -> c.output("hello: " + c.method()));

            app.get("/file/", c -> c.outputAsFile(new File("/Users/noear/Downloads/deepin-desktop-community-1010-amd64.iso")));
        });
    }
}

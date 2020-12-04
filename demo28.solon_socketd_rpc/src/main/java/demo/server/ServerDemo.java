package demo.server;

import org.noear.solon.Solon;

public class ServerDemo {
    public static void main(String[] args) {
        Solon.start(ServerDemo.class, args, app -> app.enableSocket(true));
    }
}

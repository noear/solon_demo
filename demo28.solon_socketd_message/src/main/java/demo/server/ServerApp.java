package demo.server;

import demo.client.ClientApp;
import org.noear.solon.Solon;

public class ServerApp {
    public static void main(String[] args) {
        Solon.start(ServerApp.class, args, app -> app.enableSocket(true));
    }
}

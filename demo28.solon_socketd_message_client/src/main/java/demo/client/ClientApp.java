package demo.client;

import org.noear.solon.Solon;

public class ClientApp {
    public static void main(String[] args) throws Throwable {
        Solon.start(ClientApp.class, args);

        //卡一下；因为没有任何别的服务启动
        System.in.read();
    }
}

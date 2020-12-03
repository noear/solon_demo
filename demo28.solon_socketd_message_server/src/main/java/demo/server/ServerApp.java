package demo.server;

import org.noear.solon.Solon;
import org.noear.solon.extend.socketd.SessionFactory;

import java.util.concurrent.CompletableFuture;

public class ServerApp {
    public static CompletableFuture<Boolean> status = new CompletableFuture<>();

    public static void main(String[] args) throws Throwable{
        Solon.start(ServerApp.class, args, app -> app.enableSocket(true));

        //
        // 此处只为演示需要；实际诮和不需要这个
        //
        if (status.get()) {
            SessionFactory.getOpens().forEach(session -> {
                session.send("配置是：1");
            });
        }
    }
}

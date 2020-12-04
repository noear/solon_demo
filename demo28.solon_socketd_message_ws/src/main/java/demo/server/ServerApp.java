package demo.server;

import org.noear.solon.Solon;
import org.noear.solon.extend.socketd.SessionManager;

import java.util.concurrent.CompletableFuture;

public class ServerApp {
    public static CompletableFuture<Boolean> status = new CompletableFuture<>();

    public static void main(String[] args) throws Throwable{
        //
        //smarthttp 自带了 websocket服务，与http同用8080端口
        //
        Solon.start(ServerApp.class, args, app -> {
            app.enableWebSocket(true);
            app.enableWebSocketD(true);
        });

        //
        // 此处只为演示需要；实际诮和不需要这个
        //
        if (status.get()) {
            //再待一秒，或许有更多会话边中来
            Thread.sleep(500);

            SessionManager.getOpens().forEach(session -> {
                session.send("配置是：1");
            });
        }
    }
}

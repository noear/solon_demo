import client.ClientApp;
import server.ServerApp;

public class RpcTest {
    public static void main(String[] args) throws Throwable {
        /**
         * 启动服务端
         * */
        ServerApp.main(args);

        Thread.sleep(1000);

        /**
         * 启动客户端
         * */
        ClientApp.main(args);
    }
}

package server;

import org.noear.solon.Solon;

/**
 * @author noear 2021/4/22 created
 */
public class ServerApp {
    public static void main(String[] args) {
        Solon.start(ServerApp.class, args);

        /**
         * http://localhost:8080/api/rpc/getUser
         *
         * http://localhost:8080/api/rest/getUser
         *
         * */
    }
}

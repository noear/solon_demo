package rsocktapp.demo2;

import io.rsocket.RSocket;
import io.rsocket.core.RSocketConnector;
import io.rsocket.frame.decoder.PayloadDecoder;
import io.rsocket.transport.netty.client.TcpClientTransport;

public class ClientApp {
    public static void main(String[] args){
        RSocket client = RSocketConnector.create()
                        .payloadDecoder(PayloadDecoder.ZERO_COPY)
                        .connect(TcpClientTransport.create(7878))
                        .block();
    }

    public static class ClientHandler {

    }
}

package demo.service;

import org.noear.nami.annotation.NamiClient;

@NamiClient(name = "localrpc", path = "/demoe/rpc")
public interface HelloRpcService {
    String hello(String name);
}

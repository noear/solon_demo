package demo.service;

import org.noear.fairy.annotation.FairyClient;

@FairyClient("localrpc:/demoe/rpc")
public interface HelloRpcService {
    String hello(String name);
}

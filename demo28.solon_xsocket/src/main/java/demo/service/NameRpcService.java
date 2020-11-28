package demo.service;

import org.noear.fairy.annotation.FairyClient;

@FairyClient("localrpc:/demoe/rpc/name")
public interface NameRpcService {
    String name(String name);
}

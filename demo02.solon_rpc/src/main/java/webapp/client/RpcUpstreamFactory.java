package webapp.client;

import org.noear.solon.core.XUpstream;
import org.noear.solon.core.XUpstreamFactory;

public class RpcUpstreamFactory implements XUpstreamFactory {
    XUpstream local = () -> "http://localhost:8080";

    @Override
    public XUpstream create(String service) {
        if ("local".equals(service)) {
            return local;
        } else {
            return null;
        }
    }
}

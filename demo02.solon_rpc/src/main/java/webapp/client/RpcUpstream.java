package webapp.client;

import org.noear.solon.annotation.XBean;
import org.noear.solon.core.XUpstream;

/**
 * 定义一个负载器
 * */
@XBean("local")
public class RpcUpstream implements XUpstream {
    @Override
    public String getServer() {
        return "http://localhost:8080";
    }
}

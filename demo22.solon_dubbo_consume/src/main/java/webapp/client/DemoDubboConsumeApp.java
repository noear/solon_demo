package webapp.client;

import org.noear.solon.XApp;
import org.noear.solon.extend.dubbo.EnableDubbo;

@EnableDubbo
public class DemoDubboConsumeApp {
    public static void main(String[] args) {
        XApp.start(DemoDubboConsumeApp.class, args);

//        try {
//            HttpUtils.http("http://localhost:8080/").get();
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }
    }
}

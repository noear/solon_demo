package demo;

import org.noear.solon.Solon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.management.ManagementFactory;

/**
 * @author noear 2021/5/24 created
 */
public class DemoApp {
    public static void main(String[] args){
        //它先
        String pid = ManagementFactory.getRuntimeMXBean().getName().split("@")[0];
        System.setProperty("PID", pid);

        //它后
        Logger log = LoggerFactory.getLogger(DemoApp.class);

        Solon.start(DemoApp.class, args);


        log.info("Solon 启动完成");
    }
}

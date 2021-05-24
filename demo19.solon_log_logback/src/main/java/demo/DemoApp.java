package demo;

import org.noear.solon.Solon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author noear 2021/5/24 created
 */
public class DemoApp {
    public static void main(String[] args){
        Solon.start(DemoApp.class, args);

        Logger log = LoggerFactory.getLogger(DemoApp.class);
        log.info("Solon 启动完成");
    }
}

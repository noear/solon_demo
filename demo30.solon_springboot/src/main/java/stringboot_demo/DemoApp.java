package stringboot_demo;

import org.noear.solon.Solon;
import org.noear.solon.extend.springboot.SpringBootLinkSolon;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author noear 2020/12/28 created
 */
@SpringBootLinkSolon
@SpringBootApplication
public class DemoApp {
    public static void main(String[] args) {
        //Solon.start(DemoApp.class, args);
        SpringApplication.run(DemoApp.class, args);
    }
}

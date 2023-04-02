package demo;

import lombok.extern.slf4j.Slf4j;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.core.bean.LifecycleBean;

/**
 * @author noear 2021/5/24 created
 */
@Slf4j
@Controller
public class DemoController implements LifecycleBean {

    @Override
    public void start(){
        log.info("---------------DemoApp init-----------");
    }

    @Mapping("/")
    public String hello(){
        log.info("hello at " + System.currentTimeMillis());

        return "hello world!";
    }
}

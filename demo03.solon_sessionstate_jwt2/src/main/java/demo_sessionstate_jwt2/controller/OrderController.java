package demo_sessionstate_jwt2.controller;

import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;

/**
 * @author noear 2021/8/6 created
 */
@Mapping("/order/")
@Controller
public class OrderController {
    @Mapping("list")
    public void list(){
        //...
    }
}

package webapp.controller;

import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Inject;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.data.annotation.Tran;
import webapp.dso.service.App2Service;
import webapp.dso.service.AppService;

/**
 * 多数据源事务演示
 * */
@Mapping("/tran2/")
@Controller
public class Tran2Controller {
    @Inject
    AppService appService;

    @Inject
    App2Service app2Service;


    /**
     * 申明这是一个多数据源的事务（这个可以放在任何事务的最外层；用于管理下面的子事务）
     * */
    @Tran
    @Mapping("test")
    public void test() throws Throwable {
        //内部申明了用db2的事务
        app2Service.add();

        //内部申明了用db1的事务
        appService.add();
    }
}

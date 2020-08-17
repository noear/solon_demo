package webapp.controller;

import org.noear.solon.annotation.XController;
import org.noear.solon.annotation.XInject;
import org.noear.solon.annotation.XMapping;
import org.noear.solon.annotation.XTran;
import webapp.dso.mapper.AppxMapper;
import webapp.dso.service.App2Service;
import webapp.dso.service.AppService;

/**
 * 多数据源事务演示
 * */
@XMapping("/tran2/")
@XController
public class Tran2Controller {
    @XInject
    AppService appService;

    @XInject
    App2Service app2Service;


    @XTran(multisource = true)
    @XMapping("test")
    public void test() throws Throwable {
        app2Service.add();
        appService.add();;
    }
}

package webapp.controller;

import org.noear.solon.annotation.XController;
import org.noear.solon.annotation.XInject;
import org.noear.solon.annotation.XMapping;
import org.noear.solon.annotation.XTran;
import org.noear.weed.annotation.Db;
import webapp.dso.mapper.SqlMapper;
import webapp.dso.service.AppService;

@XMapping("/tran/")
@XController
public class TranController {
    @XInject
    AppService appService;

    @XTran
    @XMapping("test")
    public void test() throws Exception {
        appService.addApp();
    }

    @XTran
    @XMapping("test2")
    public void test2() throws Exception {
        appService.addApp();

        throw new RuntimeException("不让你加");
    }

    @XMapping("test11")
    public void test11() throws Exception {
        appService.addApp2();
    }

    @XMapping("test12")
    public void test12() throws Exception {
        appService.addApp2();

        throw new RuntimeException("不让你加");
    }

    @XTran
    @XMapping("test21")
    public void test21() throws Exception {
        appService.addApp2();
    }

    @XTran
    @XMapping("test22")
    public void test22() throws Exception {
        appService.addApp2();

        throw new RuntimeException("不让你加");
    }

    @XTran(multisource = true)
    @XMapping("test31")
    public void test31() throws Exception {
        appService.addApp2();
    }

    @XTran(multisource = true)
    @XMapping("test32")
    public void test32() throws Exception {
        appService.addApp2();

        throw new RuntimeException("不让你加");
    }
}

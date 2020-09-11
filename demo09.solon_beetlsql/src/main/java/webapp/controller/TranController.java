package webapp.controller;

import org.noear.solon.annotation.*;
import webapp.dso.service.AppService;

@XMapping("/tran/")
@XController
public class TranController {
    @XInject
    AppService appService;

    @XTran
    @XMapping("test")
    public void test() throws Exception {
        //添加会成功
        //
        appService.addApp();
    }

    @XTran
    @XMapping("test2")
    public void test2() throws Exception {
        //添加会失败，因为在事务里出异常了
        //
        appService.addApp();

        throw new RuntimeException("不让你加");
    }

    @XMapping("test11")
    public void test11() throws Exception {
        //添加会成功
        //
        appService.addApp2();
    }

    @XMapping("test12")
    public void test12() throws Exception {
        //添加会成功（因为异常在事务之外） // addApp2 有事务
        //
        appService.addApp2();

        throw new RuntimeException("不让你加；但还是加了:(");
    }

    @XTran
    @XMapping("test21")
    public void test21() throws Exception {
        appService.addApp2();
    }

    @XTran
    @XMapping("test22")
    public void test22() throws Exception {
        //添加会失败，因为在事务里出异常了
        //
        appService.addApp2();

        throw new RuntimeException("不让你加");
    }


    @XTran
    @XMapping("test41")
    public void test41() throws Exception {
        //添加会成功
        //
        appService.addApp3();

        throw new RuntimeException("不让你加");
    }


    @XTran
    @XMapping("test51")
    public void test51() throws Exception {
        //添加会成功，因为addApp4是独立的新事务
        //
        appService.addApp4();

        throw new RuntimeException("不让你加，但还是成功了：（");
    }

    @XTran
    @XMapping("test52")
    public boolean test52() throws Exception {
        //添加会成功，因为addApp4是独立的新事务
        //
        appService.addApp52();
        return true;
    }

    @XTran
    @XMapping("test61")
    public void test61() throws Exception {
        //会失败
        //
        appService.addApp5();

    }


    @XMapping("test63")
    public void test63() throws Exception {
        //添加会成功
        //
        appService.addApp5();
    }

    @XTran
    @XMapping("test71")
    public void test71() throws Exception {
        //会成功
        //
        appService.addApp6();

    }

    @XMapping("test73")
    public void test73() throws Exception {
        //会失败
        //
        appService.addApp6();
    }
}

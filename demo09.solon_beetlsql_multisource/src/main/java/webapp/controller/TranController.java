package webapp.controller;

import org.noear.solon.annotation.XController;
import org.noear.solon.annotation.XInject;
import org.noear.solon.annotation.XMapping;
import org.noear.solon.annotation.XTran;
import webapp.dso.service.AppService;

@XMapping("/tran/")
@XController
public class TranController {
    @XInject
    AppService appService;

    /**
     * 多数据源时，明确哪个库。。。可增加代码可读性
     * */
    @XTran
    @XMapping("test")
    public void test() throws Exception {
        //添加成功
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
}

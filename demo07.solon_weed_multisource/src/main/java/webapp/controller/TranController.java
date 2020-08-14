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

    //@XTran(multisource = true)
    @XMapping("test")
    public Object db1() throws Exception {
        return appService.getApp("1");
    }
}

package webapp.controller;

import org.noear.solon.annotation.XController;
import org.noear.solon.annotation.XInject;
import org.noear.solon.annotation.XMapping;
import org.noear.solon.annotation.XTran;
import org.noear.weed.annotation.Db;
import webapp.dso.mapper.SqlMapper;

@XMapping("/tran/")
@XController
public class TranController {
    @XInject
    SqlMapper sqlMapper1;

    @XTran("db1")
    @XMapping("test")
    public Object db1() throws Exception {
        return sqlMapper1.appx_get2(1);
    }
}

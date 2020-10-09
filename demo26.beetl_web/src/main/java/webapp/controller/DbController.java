package webapp.controller;

import org.beetl.sql.core.SQLManager;
import org.beetl.sql.ext.solon.Db;
import org.noear.solon.annotation.XController;
import org.noear.solon.annotation.XMapping;
import webapp.model.SysUserModel;

@XController
public class DbController {
    @Db
    SQLManager manager;

    @XMapping("/dao/")
    public Object dao() {
        return manager.single(SysUserModel.class, 1);
    }
}

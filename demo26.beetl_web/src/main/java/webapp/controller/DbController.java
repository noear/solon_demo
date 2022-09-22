package webapp.controller;

import org.beetl.sql.core.SQLManager;
import org.beetl.sql.solon.annotation.Db;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;
import webapp.model.SysUserModel;

@Controller
public class DbController {
    @Db
    SQLManager manager;

    @Mapping("/dao/")
    public Object dao() {
        return manager.single(SysUserModel.class, 1);
    }
}

package webapp.controller;

import com.jfinal.plugin.activerecord.Db;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;
import webapp.model.AppxModel;

/**
 * @author noear 2021/5/24 created
 */
@Mapping("/demo/")
@Controller
public class DemoController {
    @Mapping("")
    public Object test(){
        return Db.template("appx_get").findFirst();
    }

    @Mapping("/test2")
    public Object test2(){
        AppxModel dao = new AppxModel().dao();

        return dao.findById(4);
    }
}

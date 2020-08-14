package webapp.dso.service;

import org.noear.solon.annotation.XInject;
import org.noear.solon.annotation.XTran;
import org.noear.solon.extend.aspect.XService;
import webapp.dso.mapper.SqlMapper;

@XService
public class AppService {
    @XInject
    SqlMapper sqlMapper1;

    @XTran("db1")
    public Object getApp(int app_id) throws Exception {
        return sqlMapper1.appx_get2(app_id);
    }

    public Object getApp(String app_id) throws Exception {
        return sqlMapper1.appx_get2(Integer.parseInt(app_id));
    }
}

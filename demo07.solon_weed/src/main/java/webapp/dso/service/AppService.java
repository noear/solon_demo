package webapp.dso.service;

import org.noear.solon.annotation.XInject;
import org.noear.solon.annotation.XTran;
import org.noear.solon.extend.aspect.annotation.XService;
import webapp.dso.mapper.SqlMapper;

@XService
public class AppService {
    @XInject
    SqlMapper sqlMapper1;

    public Object getApp(int app_id) throws Exception {
        return sqlMapper1.appx_get2(app_id);
    }

    public Object getApp(String app_id) throws Exception {
        return sqlMapper1.appx_get2(Integer.parseInt(app_id));
    }

    public void addApp(){
        sqlMapper1.appx_add();
    }

    @XTran
    public void addApp2(){
        sqlMapper1.appx_add();
    }
}

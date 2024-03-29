package webapp.dso.service;

import org.noear.solon.annotation.Inject;
import org.noear.solon.annotation.ProxyComponent;
import org.noear.solon.aspect.annotation.Service;
import org.noear.solon.data.annotation.Tran;
import webapp.dso.mapper.SqlMapper;

@ProxyComponent
public class AppService {
    @Inject
    SqlMapper sqlMapper1;

    @Tran
    public Object getApp(int app_id) throws Exception {
        return sqlMapper1.appx_get2(app_id);
    }

    public Object getApp(String app_id) throws Exception {
        return sqlMapper1.appx_get2(Integer.parseInt(app_id));
    }

    public void addApp(){
        sqlMapper1.appx_add();
    }

    @Tran
    public void addApp2(){
        sqlMapper1.appx_add();
    }
}

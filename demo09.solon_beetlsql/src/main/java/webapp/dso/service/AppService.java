package webapp.dso.service;

import org.beetl.sql.ext.solon.Db;
import org.noear.solon.annotation.XCache;
import org.noear.solon.annotation.XTran;
import org.noear.solon.core.TranPolicy;
import org.noear.solon.extend.aspect.annotation.XService;
import webapp.dso.mapper.SqlMapper;

@XService
public class AppService {
    @Db
    SqlMapper sqlMapper1;

    public Object getApp(int app_id) throws Exception {
        return sqlMapper1.appx_get2(app_id);
    }

    public Object getApp(String app_id) throws Exception {
        return sqlMapper1.appx_get2(Integer.parseInt(app_id));
    }

    public void addApp(){
        sqlMapper1.appx_add(1);
    }

    @XTran
    public void addApp2(){
        sqlMapper1.appx_add(1);
    }

    @XTran(policy = TranPolicy.nested)
    public void addApp3(){
        sqlMapper1.appx_add(1);
    }

    @XTran(policy = TranPolicy.requires_new)
    public boolean addApp4(){
        sqlMapper1.appx_add(1);
        return true;
    }

    @XCache(seconds = 10)
    @XTran(policy = TranPolicy.requires_new)
    public boolean addApp52(){
        sqlMapper1.appx_add(1);
        return true;
    }

    @XTran(policy = TranPolicy.never)
    public void addApp5(){
        sqlMapper1.appx_add(1);
    }

    @XTran(policy = TranPolicy.mandatory)
    public void addApp6(){
        sqlMapper1.appx_add(1);
    }
}

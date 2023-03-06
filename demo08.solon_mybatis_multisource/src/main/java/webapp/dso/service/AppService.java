package webapp.dso.service;

import org.noear.solon.annotation.Inject;
import org.noear.solon.annotation.ProxyComponent;
import org.noear.solon.aspect.annotation.Service;
import org.noear.solon.data.annotation.Tran;
import webapp.dso.mapper.AppxMapper;

@ProxyComponent
public class AppService {
    @Inject
    AppxMapper appxMapper;

    /**
     * 申明使用db1的事务
     * */
    @Tran
    public void add(){
        appxMapper.appx_add();
    }
}

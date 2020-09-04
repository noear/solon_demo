package webapp.dso.service;

import org.noear.solon.annotation.XInject;
import org.noear.solon.annotation.XTran;
import org.noear.solon.extend.aspect.annotation.XService;
import webapp.dso.mapper.AppxMapper;

@XService
public class AppService {
    @XInject
    AppxMapper appxMapper;

    /**
     * 申明使用db1的事务
     * */
    @XTran
    public void add(){
        appxMapper.appx_add();
    }
}

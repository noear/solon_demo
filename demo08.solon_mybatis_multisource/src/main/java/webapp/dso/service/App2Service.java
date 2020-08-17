package webapp.dso.service;

import org.noear.solon.annotation.XInject;
import org.noear.solon.annotation.XTran;
import org.noear.solon.extend.aspect.annotation.XService;
import webapp.dso.mapper.Appx2Mapper;

@XService
public class App2Service {
    @XInject
    Appx2Mapper appxMapper2;

    /**
     * 申明使用db2的事务
     * */
    @XTran("db2")
    public void add(){
        appxMapper2.appx_add();
    }
}

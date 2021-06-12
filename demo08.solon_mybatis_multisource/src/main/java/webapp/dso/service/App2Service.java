package webapp.dso.service;

import org.noear.solon.annotation.Inject;
import org.noear.solon.extend.aspect.annotation.Service;
import org.noear.solon.data.annotation.Tran;
import webapp.dso.mapper.Appx2Mapper;

@Service
public class App2Service {
    @Inject
    Appx2Mapper appxMapper2;

    /**
     * 申明使用db2的事务
     * */
    @Tran
    public void add(){
        appxMapper2.appx_add();
    }
}

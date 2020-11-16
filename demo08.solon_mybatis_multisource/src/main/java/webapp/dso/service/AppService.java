package webapp.dso.service;

import org.noear.solon.annotation.Inject;
import org.noear.solon.extend.aspect.annotation.Service;
import org.noear.solon.extend.data.annotation.Tran;
import webapp.dso.mapper.AppxMapper;

@Service
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

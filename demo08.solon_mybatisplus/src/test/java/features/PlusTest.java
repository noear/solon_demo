package features;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.noear.solon.annotation.Inject;
import org.noear.solon.test.SolonJUnit4ClassRunner;
import org.noear.solon.test.SolonTest;
import org.noear.weed.annotation.Db;
import webapp.DemoApp;
import webapp.dso.mapper.AppxMapper;
import webapp.dso.mapper.AppxMapper2;
import webapp.model.AppxModel;

/**
 * @author noear 2021/9/3 created
 */
@RunWith(SolonJUnit4ClassRunner.class)
@SolonTest(DemoApp.class)
public class PlusTest {

    @Inject
    AppxMapper2 appxMapper2;

    @Inject
    AppxMapper appxMapper;

    @Test
    public void test() {
        AppxModel app0 =  appxMapper.appx_get();
        System.out.println(app0);

        AppxModel app1 =  appxMapper.appx_get2(2);
        System.out.println(app1);

        AppxModel app = appxMapper2.selectById(2);
        System.out.println(app);

        assert app != null;
        assert app.getAppId() == 2;
    }
}

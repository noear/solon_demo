package features;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.noear.solon.annotation.Inject;
import org.noear.solon.test.SolonJUnit4ClassRunner;
import org.noear.solon.test.SolonTest;
import webapp.DemoApp;
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

    @Test
    public void test() {
        AppxModel app = appxMapper2.selectById(2);
        System.out.println(app);

        assert app != null;
        assert app.getAppId() == 2;
    }
}

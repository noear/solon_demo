package features;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.noear.snack.ONode;
import org.noear.solon.test.HttpTestBase;
import org.noear.solon.test.SolonJUnit4ClassRunner;
import org.noear.solon.test.SolonTest;
import webapp.DemoApp;

/**
 * @author noear 2021/9/27 created
 */
@RunWith(SolonJUnit4ClassRunner.class)
@SolonTest(DemoApp.class)
public class DemoTest extends HttpTestBase {
    @Test
    public void test() throws Exception {
        String json = path("/demo/test").get();
        assert ONode.loadStr(json).count() > 2;
    }

    @Test
    public void test2() throws Exception {
        String json = path("/demo/test2").get();
        assert ONode.loadStr(json).count() > 2;
    }
}

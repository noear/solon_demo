package features;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.noear.solon.test.SolonJUnit4ClassRunner;
import org.noear.solon.test.SolonTest;
import org.noear.weed.annotation.Db;
import webapp.DemoApp;
import webapp.dso.mapper.SqlMapper;

/**
 * @author noear 2021/2/3 created
 */
@RunWith(SolonJUnit4ClassRunner.class)
@SolonTest(DemoApp.class)
public class Test0 {
    @Db
    SqlMapper sqlMapper;

    @Test
    public void test0() throws Exception{
        Integer tmp = sqlMapper.appx_get0();
        assert  tmp == null;

        assert  sqlMapper.appx_get() > 0;
    }
}

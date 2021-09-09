package features;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.solon.pagination.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.noear.solon.annotation.Inject;
import org.noear.solon.test.SolonJUnit4ClassRunner;
import org.noear.solon.test.SolonTest;
import webapp.DemoApp;
import webapp.dso.mapper.AppxMapper2;
import webapp.model.AppxModel;
import com.baomidou.mybatisplus.core.metadata.IPage;


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


    @Test
    public void test2() {
        Page<AppxModel> page = new Page<>(1, 10);
        IPage<AppxModel> iPage = appxMapper2.selectPage(page, new QueryWrapper<>());


        assert iPage != null;

        System.out.println("iPage.getRecords().size(): " + iPage.getRecords().size());
        assert iPage.getRecords().size() > 0;

        System.out.println("iPage.getTotal(): " + iPage.getTotal());
        assert iPage.getTotal() > 0;
    }
}

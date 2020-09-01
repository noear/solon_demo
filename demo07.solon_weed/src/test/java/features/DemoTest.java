package features;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.noear.solon.core.Aop;
import org.noear.solon.test.HttpTestBase;
import org.noear.solon.test.SolonBootTest;
import org.noear.solon.test.SolonJUnit4ClassRunner;
import org.noear.weed.DbContext;
import webapp.DemoApp;

@RunWith(SolonJUnit4ClassRunner.class)
@SolonBootTest(DemoApp.class)
public class DemoTest extends HttpTestBase {
    @Test
    public void test() throws Exception {
        DbContext db = Aop.get(DbContext.class);
        clear(db);
        path("/tran/test").get();
        path("/tran/test").get();
        path("/tran/test").get();
        assert db.table("test").count() == 3;
    }

    @Test
    public void test2() throws Exception {
        DbContext db = Aop.get(DbContext.class);
        clear(db);
        path("/tran/test2").get();
        path("/tran/test2").get();
        path("/tran/test2").get();
        assert db.table("test").count() == 0;
    }

    @Test
    public void test11() throws Exception {
        DbContext db = Aop.get(DbContext.class);
        clear(db);
        path("/tran/test11").get();
        path("/tran/test11").get();
        path("/tran/test11").get();
        assert db.table("test").count() == 3;
    }

    @Test
    public void test12() throws Exception {
        DbContext db = Aop.get(DbContext.class);
        clear(db);
        path("/tran/test12").get();
        path("/tran/test12").get();
        path("/tran/test12").get();
        assert db.table("test").count() == 3;
    }

    @Test
    public void test21() throws Exception {
        DbContext db = Aop.get(DbContext.class);
        clear(db);
        path("/tran/test21").get();
        path("/tran/test21").get();
        path("/tran/test21").get();
        assert db.table("test").count() == 3;
    }

    @Test
    public void test22() throws Exception {
        DbContext db = Aop.get(DbContext.class);
        clear(db);
        path("/tran/test22").get();
        path("/tran/test22").get();
        path("/tran/test22").get();
        long count = db.table("test").count();
        System.out.println(count);
        assert count == 0;
    }

    @Test
    public void test31() throws Exception {
        DbContext db = Aop.get(DbContext.class);
        clear(db);
        path("/tran/test31").get();
        path("/tran/test31").get();
        path("/tran/test31").get();
        assert db.table("test").count() == 3;
    }

    @Test
    public void test32() throws Exception {
        DbContext db = Aop.get(DbContext.class);
        clear(db);
        path("/tran/test32").get();
        path("/tran/test32").get();
        path("/tran/test32").get();
        assert db.table("test").count() == 0;
    }

    @Test
    public void test41() throws Exception {
        DbContext db = Aop.get(DbContext.class);
        clear(db);
        path("/tran/test41").get();
        path("/tran/test41").get();
        path("/tran/test41").get();
        assert db.table("test").count() == 3;
    }

    @Test
    public void test42() throws Exception {
        DbContext db = Aop.get(DbContext.class);
        clear(db);
        path("/tran/test42").get();
        path("/tran/test42").get();
        path("/tran/test42").get();
        assert db.table("test").count() == 0;
    }

    private void clear(DbContext db) throws Exception {
        db.exe("TRUNCATE TABLE test");
    }
}

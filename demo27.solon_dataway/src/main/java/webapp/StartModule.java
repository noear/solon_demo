package webapp;

import com.zaxxer.hikari.HikariDataSource;
import net.hasor.core.ApiBinder;
import net.hasor.db.JdbcModule;
import net.hasor.db.Level;
import net.hasor.web.WebApiBinder;
import net.hasor.web.WebModule;
import org.noear.solon.XApp;
import org.noear.solon.core.Aop;

import javax.sql.DataSource;

public class StartModule implements WebModule {
    @Override
    public void loadModule(ApiBinder apiBinder) throws Throwable {
        DataSource ds = Aop.inject(new HikariDataSource(), XApp.cfg().getProp("db1"));
        apiBinder.installModule(new JdbcModule(Level.Full, ds));
    }

    @Override
    public void loadModule(WebApiBinder webApiBinder) throws Throwable {
        DataSource ds = Aop.inject(new HikariDataSource(), XApp.cfg().getProp("db1"));
        webApiBinder.installModule(new JdbcModule(Level.Full, ds));
    }
}

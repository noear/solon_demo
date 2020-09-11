package webapp;

import com.zaxxer.hikari.HikariDataSource;
import org.noear.solon.XApp;
import org.noear.solon.annotation.XBean;
import org.noear.solon.annotation.XConfiguration;
import org.noear.solon.annotation.XInject;
import org.noear.weed.DbContext;

@XConfiguration
public class Config {
    @XBean("db1")
    public DbContext db1(@XInject("${test.db1}") HikariDataSource dataSource) {
        String schema = dataSource.getSchema();
        return new DbContext(schema, dataSource);
    }

    @XBean("db2")
    public DbContext db2(@XInject("${test.db2}") HikariDataSource dataSource) {
        String schema = dataSource.getSchema();
        return new DbContext(schema, dataSource);
    }
}

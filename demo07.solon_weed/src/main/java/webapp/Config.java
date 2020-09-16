package webapp;

import com.zaxxer.hikari.HikariDataSource;
import org.noear.solon.XApp;
import org.noear.solon.annotation.XBean;
import org.noear.solon.annotation.XConfiguration;
import org.noear.solon.annotation.XInject;
import org.noear.weed.DbContext;

import javax.sql.DataSource;

@XConfiguration
public class Config {
    @XBean
    public DataSource db1(@XInject("${test.db1}") HikariDataSource ds) {
        return ds;
    }
}


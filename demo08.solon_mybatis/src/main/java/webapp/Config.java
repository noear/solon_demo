package webapp;

import com.zaxxer.hikari.HikariDataSource;
import org.noear.solon.annotation.XBean;
import org.noear.solon.annotation.XConfiguration;
import org.noear.solon.annotation.XInject;

import javax.sql.DataSource;

@XConfiguration
public class Config {
    @XBean(value = "db1", typed = true)
    public DataSource db1(@XInject("${test.db1}") HikariDataSource ds) {
       return ds;
    }
}

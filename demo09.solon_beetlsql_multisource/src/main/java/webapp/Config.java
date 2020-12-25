package webapp;

import com.zaxxer.hikari.HikariDataSource;
import org.noear.solon.Solon;
import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Configuration;
import org.noear.solon.annotation.Inject;
import org.noear.weed.DbContext;

import javax.sql.DataSource;

@Configuration
public class Config {
    //
    //  申明 db2 是 db1 为的从库
    //
    @Bean(value = "db1", attrs = {"slaves=db2"})
    public DataSource db1(@Inject("${test.db1}") HikariDataSource dataSource) {
        return dataSource;
    }

    @Bean("db2")
    public DataSource db2(@Inject("${test.db2}") HikariDataSource dataSource) {
        return dataSource;
    }
}


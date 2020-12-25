package webapp;

import com.zaxxer.hikari.HikariDataSource;
import org.noear.solon.Solon;
import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Configuration;
import org.noear.solon.annotation.Inject;
import org.noear.weed.DbContext;

@Configuration
public class Config {
    //@Bean(value="db1", attrs = {"slaves=db2","dialect=oracle"}) //通过特性，指定BeetlSQL的方言
    @Bean("db1")
    public DbContext db1(@Inject("${test.db1}") HikariDataSource dataSource) {
        String schema = dataSource.getSchema();
        return new DbContext(schema, dataSource);
    }

    @Bean("db2")
    public DbContext db2(@Inject("${test.db2}") HikariDataSource dataSource) {
        String schema = dataSource.getSchema();
        return new DbContext(schema, dataSource);
    }
}


package webapp;

import com.zaxxer.hikari.HikariDataSource;
import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Configuration;
import org.noear.solon.annotation.Inject;

import javax.sql.DataSource;


@Configuration
public class Config {
    //@Bean(attrs = {"dialect=oracle"}) //通过特性，指定BeetlSQL的方言
    @Bean
    public DataSource db1(@Inject("${test.db1}") HikariDataSource dataSource) {
        return dataSource;
    }
}


package webapp;

import com.zaxxer.hikari.HikariDataSource;
import org.beetl.sql.core.SQLManager;
import org.beetl.sql.ext.solon.Db;
import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Configuration;
import org.noear.solon.annotation.Init;
import org.noear.solon.annotation.Inject;

import javax.sql.DataSource;


@Configuration
public class Config {
    //@Bean(attrs = {"dialect=oracle"}) //通过特性，指定BeetlSQL的方言
    @Bean
    public DataSource db1(@Inject("${test.db1}") HikariDataSource dataSource) {
        return dataSource;
    }

    @Db
    SQLManager sqlManager;


    @Init
    public void init(){
        //sqlManager.addIdAutoGen();
    }
}


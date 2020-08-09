package webapp;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.noear.solon.XApp;
import org.noear.solon.annotation.XBean;
import org.noear.solon.annotation.XConfiguration;
import org.noear.solon.annotation.XInject;
import org.noear.solon.core.XMap;
import org.noear.solon.extend.mybatis.MybatisAdapter;

import java.io.IOException;
import java.io.Reader;
import java.util.Properties;


@XConfiguration
public class Config {
    @XBean("db1f")
    public SqlSessionFactory db1f(@XInject("${test.db1}") HikariDataSource dataSource) {
        //
        //可以用默认的配置
        //
        return new MybatisAdapter(dataSource)
                .mapperScan("webapp.dso.db1")   //替代@mapperScan注解（相对来说，可以把多个 mapperScan 安排在一个 Config里）
                .getFactory();
    }

    @XBean("db2f")
    public SqlSessionFactory db2f(
            @XInject("${test.db2}") HikariDataSource dataSource,
            @XInject("${mybatis.db2f}") Properties props) {
        //
        //可以指定配置 ${mybatis.db2f}
        //
        return new MybatisAdapter(dataSource, props)
                .mapperScan("webapp.dso.db2")
                .getFactory();
    }
}

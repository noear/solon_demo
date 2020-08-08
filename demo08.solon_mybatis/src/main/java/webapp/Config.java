package webapp;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.noear.solon.annotation.XBean;
import org.noear.solon.annotation.XConfiguration;
import org.noear.solon.annotation.XInject;
import org.noear.solon.extend.mybatis.MapperScan;
import org.noear.solon.extend.mybatis.SqlSessionFactoryBean;

import java.util.Properties;

@MapperScan(basePackages = "webapp.dso.db1", sqlSessionFactoryRef = "db1f")
@XConfiguration
public class Config {
    @XBean("db1f")
    public SqlSessionFactory sqlSessionFactory1(
            @XInject("${test.db1}") HikariDataSource dataSource,
            @XInject("${mybatis.db1f}") Properties props) {
        return new SqlSessionFactoryBean(dataSource, props).getObject();
    }

    @XBean("db1f2")
    public SqlSessionFactory sqlSessionFactory2(
            @XInject("${test.db2}") HikariDataSource dataSource,
            @XInject("${mybatis.db1f}") Properties props ) {
        return new SqlSessionFactoryBean(dataSource, props).getObject();
    }
}

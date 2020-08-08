package webapp;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.noear.solon.annotation.XBean;
import org.noear.solon.annotation.XConfiguration;
import org.noear.solon.annotation.XInject;
import org.noear.solon.extend.mybatis.MapperScan;
import org.noear.solon.extend.mybatis.MybatisAdapter;

import java.util.Properties;

@MapperScan(basePackages = "webapp.dso.db2", sqlSessionFactoryRef = "db2f")
@XConfiguration
public class Config2 {
    @XBean("db2f")
    public SqlSessionFactory db2f(
            @XInject("${test.db2}") HikariDataSource dataSource,
            @XInject("${mybatis.db2f}") Properties props) {
        //
        //可以指定配置
        //
        return new MybatisAdapter(dataSource, props).getFactory();
    }
}

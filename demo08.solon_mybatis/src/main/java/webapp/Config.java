package webapp;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionManager;
import org.noear.solon.annotation.XBean;
import org.noear.solon.annotation.XConfiguration;
import org.noear.solon.annotation.XInject;

import javax.sql.DataSource;
import java.sql.DataTruncation;

@XConfiguration
public class Config {
    @XBean("dataSource1")
    public DataSource dataSource1(@XInject("${test.db1}") HikariDataSource dataSource) {
        return dataSource;
    }

    @XBean("sqlSessionFactory1")
    public SqlSessionFactory sqlSessionFactory1(@XInject("dataSource1") DataSource dataSource1){
        return new SqlSessionFactoryBean(dataSource1).build();
    }

    
}

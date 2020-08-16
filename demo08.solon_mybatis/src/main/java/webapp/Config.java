package webapp;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.noear.solon.annotation.XBean;
import org.noear.solon.annotation.XConfiguration;
import org.noear.solon.annotation.XInject;
import org.noear.solon.extend.mybatis.MybatisAdapter;

@XConfiguration
public class Config {
    @XBean
    public SqlSessionFactory db1(@XInject("${test.db1}") HikariDataSource dataSource) {
        //
        //可以用默认的配置
        //
        return new MybatisAdapter(dataSource)
                .mapperScan()   //完成Spring 的 @mapperScan注解的功能（相对来说，改成函数可以把多个 mapperScan 安排在一个 Config里）
                .getFactory();
    }
}

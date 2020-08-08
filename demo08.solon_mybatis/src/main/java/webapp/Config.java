package webapp;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.noear.solon.annotation.XBean;
import org.noear.solon.annotation.XConfiguration;
import org.noear.solon.annotation.XInject;
import org.noear.solon.extend.mybatis.MapperScan;
import org.noear.solon.extend.mybatis.MybatisAdapter;

/**
 * MapperScan 的作用：
 * 扫描 @basePackages 里的类，
 * 然后 用 @sqlSessionFactoryRef 生成 mapper 实例
 * 最后 注册到 bean 管理中心
 * */
@MapperScan(basePackages = "webapp.dso.db1", sqlSessionFactoryRef = "db1f")
@XConfiguration
public class Config {
    @XBean("db1f")
    public SqlSessionFactory db1f(@XInject("${test.db1}") HikariDataSource dataSource) {
        //
        //可以用默认的配置
        //
        return new MybatisAdapter(dataSource).getFactory();
    }
}

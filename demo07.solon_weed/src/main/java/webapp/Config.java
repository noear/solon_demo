package webapp;

import com.zaxxer.hikari.HikariDataSource;
import org.noear.solon.XApp;
import org.noear.solon.annotation.XBean;
import org.noear.solon.annotation.XConfiguration;
import org.noear.solon.annotation.XInject;
import org.noear.weed.DbContext;

@XConfiguration
public class Config {

    /**
     * 数据库上下文配置
     *
     * @param dataSource 根据配置注入一个 HikariDataSource 实例（配置的属性要与HikariDataSource字段对应）
     */
    @XBean("db2")
    public DbContext db1(@XInject("${test.db2}") HikariDataSource dataSource) {
        //直接读配置的演示
        //
        String schema = XApp.cfg().get("test.db2.schema");
        return new DbContext(schema, dataSource);
    }
}

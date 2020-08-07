package webapp;

import com.zaxxer.hikari.HikariDataSource;
import org.noear.solon.XApp;
import org.noear.solon.annotation.XBean;
import org.noear.solon.annotation.XConfiguration;
import org.noear.solon.annotation.XInject;
import org.noear.solon.core.XMap;
import org.noear.weed.DbContext;
import org.noear.weed.cache.ICacheServiceEx;
import org.noear.weed.cache.LocalCache;

import java.util.Properties;

/**
 * 注入模式演示
 * */
@XConfiguration
public class Config2 {
    /**
     * 缓存服务配置
     */
    @XBean("cache2")
    public ICacheServiceEx cache1() {
        //实例化一个本地缓存服务
        //
        return new LocalCache("test", 60).nameSet("cache2");
    }

    /**
     * 数据库上下文配置
     *
     * @param dataSource 根据配置注入一个 HikariDataSource 实例（配置的属性要与HikariDataSource字段对应）
     */
    @XBean("db2")
    public DbContext db2(@XInject("${test.db2}") HikariDataSource dataSource) {
        //直接读配置的演示
        //
        String schema = XApp.cfg().get("test.db2.schema");
        return new DbContext(schema, dataSource).nameSet("db2");
    }
}

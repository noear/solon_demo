package webapp;

import com.zaxxer.hikari.HikariDataSource;
import org.noear.solon.Solon;
import org.noear.solon.Utils;
import org.noear.solon.annotation.Configuration;
import org.noear.solon.core.Aop;
import org.noear.weed.DbContext;
import org.noear.weed.cache.ICacheServiceEx;
import org.noear.weed.cache.LocalCache;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * 静态模式演示
 * */
@Configuration
public class Config {
    //
    //缓存服务配置:: //新建个缓存服务，并通过nameSet 注册到 全局 libOfCache
    //
    public static ICacheServiceEx cache1 = new LocalCache("test",60).nameSet("cache1");


    //
    //使用连接池 配置 数据库上下文
    //
    private final static DbContext build() {
        Properties prop = Solon.cfg().getProp("test.db1");
        String schema = prop.getProperty("schema");


        //利于一个solon的内部工具
        //
        DataSource dataSource = Utils.injectProperties(new HikariDataSource(), prop);

        return new DbContext(schema, dataSource);
    }

    /**
     * 使用静态模式
     * */
    public final static DbContext db1 = build();
}

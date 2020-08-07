package webapp;

import com.zaxxer.hikari.HikariDataSource;
import org.noear.solon.XApp;
import org.noear.solon.annotation.XConfiguration;
import org.noear.solon.core.ClassWrap;
import org.noear.weed.DbContext;
import org.noear.weed.cache.ICacheServiceEx;
import org.noear.weed.cache.LocalCache;

import java.util.Properties;

/**
 * 静态模式演示
 * */
@XConfiguration
public class Config {
    //
    //缓存服务配置:: //新建个缓存服务，并通过nameSet 注册到 全局 libOfCache
    //
    public ICacheServiceEx cache = new LocalCache("test",60).nameSet("test");


    //
    //使用连接池 配置 数据库上下文
    //
    private final static DbContext build(){
        Properties prop = XApp.cfg().getProp("test.db1");
        String schema = prop.getProperty("schema");

        //利于一个solon的内部工具
        //
        HikariDataSource dataSource = ClassWrap.get(HikariDataSource.class)
                .newBy(prop::getProperty);

        return new DbContext(schema, dataSource);
    }

    /**
     * 使用静态模式
     * */
    public final static DbContext db1 = build();
}

package webapp;

import com.zaxxer.hikari.HikariDataSource;
import org.noear.solon.annotation.XBean;
import org.noear.solon.annotation.XConfiguration;
import org.noear.solon.annotation.XInject;
import org.noear.weed.DbContext;

@XConfiguration
public class Config2 {

    /**
     * 用于做单元测试清数据用
     * */
    @XBean
    public DbContext db1w(@XInject("${test.db1}") HikariDataSource dataSource) {
        String schema = dataSource.getSchema();
        return new DbContext(schema, dataSource);
    }
}

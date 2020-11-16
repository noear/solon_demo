package webapp;

import com.zaxxer.hikari.HikariDataSource;
import org.noear.solon.XUtil;
import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Configuration;
import org.noear.solon.annotation.Inject;
import org.noear.solon.core.CacheService;
import org.noear.solon.extend.validation.ValidatorManager;
import org.noear.solon.extend.validation.annotation.Date;
import org.noear.solon.extend.validation.annotation.DateValidator;
import webapp.dso.NotCacheService;
import webapp.utils.DsHelper;

import javax.sql.DataSource;
import java.io.IOException;


@Configuration
public class Config {
    @Bean
    public void validAdapter() {
        //
        // 添加Date验证器
        //
        ValidatorManager.global().register(Date.class, DateValidator.instance);
        //
        // 适配验证输出
        //
        ValidatorManager.global().onFailure((ctx, ano, rst, message) -> {
            ctx.setHandled(true);

            if (XUtil.isEmpty(message)) {
                message = new StringBuilder(100)
                        .append("@")
                        .append(ano.annotationType().getSimpleName())
                        .append(" verification failed")
                        .toString();
            }

            ctx.output(message);

            return true;
        });
    }

    @Bean
    public DataSource db1(@Inject("${db1}") HikariDataSource ds) throws IOException {
        DsHelper.initData(ds);
        
        return ds;
    }
}

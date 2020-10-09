package webapp;

import com.zaxxer.hikari.HikariDataSource;
import org.noear.solon.XUtil;
import org.noear.solon.annotation.XBean;
import org.noear.solon.annotation.XConfiguration;
import org.noear.solon.annotation.XInject;
import org.noear.solon.core.CacheService;
import org.noear.solon.extend.validation.ValidatorManager;
import org.noear.solon.extend.validation.annotation.Date;
import org.noear.solon.extend.validation.annotation.DateValidator;
import webapp.dso.NotCacheService;
import webapp.utils.DsHelper;

import javax.sql.DataSource;
import java.io.IOException;


@XConfiguration
public class Config {
    @XBean
    public void validAdapter() {
        ValidatorManager.global().register(Date.class, DateValidator.instance);


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

    @XBean
    public DataSource ds(@XInject("${db1}") HikariDataSource ds) throws IOException {
        DsHelper.initData(ds);
        
        return ds;
    }
}

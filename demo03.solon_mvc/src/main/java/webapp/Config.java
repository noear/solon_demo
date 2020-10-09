package webapp;

import org.noear.solon.XUtil;
import org.noear.solon.annotation.XBean;
import org.noear.solon.annotation.XConfiguration;
import org.noear.solon.core.CacheService;
import org.noear.solon.extend.validation.ValidatorManager;
import org.noear.solon.extend.validation.annotation.Date;
import org.noear.solon.extend.validation.annotation.DateValidator;
import webapp.dso.NotCacheService;


@XConfiguration
public class Config {
    @XBean
    public void validAdapter() {
        //
        // 添加Date验证器
        //
        ValidatorManager.global().register(Date.class, DateValidator.instance);
        //
        // 适配验证输出，更友好些
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

    /**
     *
     */
//    @XBean
//    public CacheService cache() {
//        return new NotCacheService();
//    }

//    @XBean("cache1")
//    public CacheService cache1(@XInject("${cache1}") Properties props) {
//        return new MemCacheService(props);
//    }

}

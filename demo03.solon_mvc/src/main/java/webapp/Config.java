package webapp;

import org.noear.solon.Utils;
import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Configuration;
import org.noear.solon.extend.validation.ValidatorManager;
import org.noear.solon.extend.validation.annotation.Date;
import org.noear.solon.extend.validation.annotation.DateValidator;


@Configuration
public class Config {
    @Bean
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

            if (Utils.isEmpty(message)) {
                message = new StringBuilder(100)
                        .append("@")
                        .append(ano.annotationType().getSimpleName())
                        .append(" verification failed(")
                        .append(rst.getDescription()).append(")")
                        .toString();
            }

            ctx.output(message);

            return true;
        });
    }

    /**
     *
     */
//    @Bean
//    public CacheService cache() {
//        return new NotCacheService();
//    }

//    @Bean("cache1")
//    public CacheService cache1(@Inject("${cache1}") Properties props) {
//        return new MemCacheService(props);
//    }

}

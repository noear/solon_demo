package webapp;

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
    public void adapter() {
        ValidatorManager.global().register(Date.class, DateValidator.instance);
    }

    /**
     *
     */
    @XBean
    public CacheService cache() {
        return new NotCacheService();
    }

//    @XBean("cache1")
//    public CacheService cache1(@XInject("${cache1}") Properties props) {
//        return new MemCacheService(props);
//    }

}

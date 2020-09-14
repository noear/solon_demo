package webapp;

import com.sun.javaws.security.AppContextUtil;
import org.noear.solon.XUtil;
import org.noear.solon.annotation.XBean;
import org.noear.solon.annotation.XConfiguration;
import org.noear.solon.annotation.XInject;
import org.noear.solon.core.CacheService;
import org.noear.solon.extend.validation.ValidatorManager;
import org.noear.solon.extend.validation.annotation.Date;
import org.noear.solon.extend.validation.annotation.DateValidator;
import org.noear.solon.extend.validation.annotation.WhitelistValidator;
import webapp.dso.MemCacheService;
import webapp.dso.NotCacheService;
import webapp.dso.WhitelistValidatorImpl;

import javax.security.auth.login.CredentialException;
import java.util.Properties;

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


    @XBean
    public WhitelistValidator whitelistValidator(){
        return new WhitelistValidatorImpl();
    }
}

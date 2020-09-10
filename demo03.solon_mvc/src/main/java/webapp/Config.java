package webapp;

import org.noear.solon.XUtil;
import org.noear.solon.annotation.XBean;
import org.noear.solon.annotation.XConfiguration;
import org.noear.solon.extend.validation.ValidatorManager;
import org.noear.solon.extend.validation.annotation.Date;
import org.noear.solon.extend.validation.annotation.DateValidator;

@XConfiguration
public class Config {
    @XBean
    public void adapter() {
        ValidatorManager.global().register(Date.class, DateValidator.instance);
    }
}

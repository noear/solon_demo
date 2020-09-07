package webapp;

import org.noear.solon.XUtil;
import org.noear.solon.annotation.XBean;
import org.noear.solon.annotation.XConfiguration;
import org.noear.solon.extend.validation.ValidatorManager;

@XConfiguration
public class Config {
    @XBean
    public void init() {
        ValidatorManager.globalSet(new ValidatorManager((ctx, ano, rst, msg) -> {
            ctx.setHandled(true);

            if (XUtil.isEmpty(msg)) {
                msg = ano.annotationType().getSimpleName() + " verification failed: " + rst.getDescription();
            }

            ctx.output(msg);

            return true;
        }));
    }
}

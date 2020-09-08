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
                msg = new StringBuilder(100)
                        .append("@")
                        .append(ano.annotationType().getSimpleName())
                        .append(" verification failed: ")
                        .append(rst.getDescription())
                        .toString();
            }

            ctx.output(msg);

            return true;
        }));
    }
}

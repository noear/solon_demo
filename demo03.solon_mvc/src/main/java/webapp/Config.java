package webapp;

import org.noear.solon.XUtil;
import org.noear.solon.annotation.XBean;
import org.noear.solon.annotation.XConfiguration;
import org.noear.solon.extend.validation.ValidatorManager;

@XConfiguration
public class Config {
    @XBean
    public void adapter() {
        ValidatorManager.globalSet(new ValidatorManager((ctx, ano, rst, message) -> {
            ctx.setHandled(true);

            if (XUtil.isEmpty(message)) {
                if(XUtil.isEmpty(rst.getDescription())){
                    message = new StringBuilder(100)
                            .append("@")
                            .append(ano.annotationType().getSimpleName())
                            .append(" verification failed")
                            .toString();
                }else{
                    message = new StringBuilder(100)
                            .append("@")
                            .append(ano.annotationType().getSimpleName())
                            .append(" verification failed: ")
                            .append(rst.getDescription())
                            .toString();
                }
            }

            ctx.output(message);

            return true;
        }));
    }
}

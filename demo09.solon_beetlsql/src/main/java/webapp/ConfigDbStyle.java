package webapp;

import org.beetl.sql.core.SQLManagerBuilder;
import org.beetl.sql.core.db.MySqlStyle;
import org.noear.solon.annotation.Component;
import org.noear.solon.core.event.EventListener;

/**
 * @author noear 2020/12/22 created
 */
@Component
public class ConfigDbStyle implements EventListener<SQLManagerBuilder> {
    @Override
    public void onEvent(SQLManagerBuilder builder) {
        //方言设置；默认是Mysql；
        builder.setDbStyle(new MySqlStyle());
    }
}

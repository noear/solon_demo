package webapp.widget;

import com.jfinal.template.Directive;
import com.jfinal.template.Env;
import com.jfinal.template.io.Writer;
import com.jfinal.template.stat.Scope;
import org.noear.solon.annotation.Bean;

@Bean("view:footer")
public class FooterTag extends Directive {
    @Override
    public void exec(Env env, Scope scope, Writer writer) {
        StringBuffer sb = new StringBuffer();

        sb.append("<footer>");
        sb.append("我是自定义标签，FooterTag");
        sb.append("</footer>");

        try {
            writer.write(sb.toString());
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}

package webapp.widget;


import org.beetl.core.tag.Tag;
import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Component;

/**
 * 自定义标签
 * */
@Component("view:footer")
public class FooterTag extends Tag {

    @Override
    public void render() {
        StringBuffer sb = new StringBuffer();

        sb.append("<footer>");
        sb.append("::我是自定义标签，FooterTag");
        sb.append("</footer>");

        try {
            ctx.byteWriter.writeString(sb.toString());
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}

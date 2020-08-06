package webapp.widget;

import org.noear.solon.core.XContext;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class FooterTag extends TagSupport {
    @Override
    public int doStartTag() throws JspException {
        try {
            String path = XContext.current().path();

            //当前视图path
            StringBuffer sb = new StringBuffer();
            sb.append("<footer>");
            sb.append("我是自定义标签，FooterTag；当前path=").append(path);
            sb.append("</footer>");
            pageContext.getOut().write(sb.toString());
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return super.doStartTag();
    }

    @Override
    public int doEndTag() throws JspException {
        return super.doEndTag();
    }
}
import org.noear.solon.XApp;
import org.noear.solon.annotation.XController;
import org.noear.solon.annotation.XMapping;
import org.noear.solon.core.Aop;

@XController
public class TmpApp {
    public static void main(String[] args) {
        XApp.start(TmpApp.class, args);

        //测试
        TmpApp tmp = Aop.get(TmpApp.class);
        System.out.println(tmp.helloworld());
    }

    @XMapping("/")
    public String helloworld(){
        return "Hello world";
    }
}

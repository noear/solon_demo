import org.noear.solon.XApp;
import org.noear.solon.annotation.XController;
import org.noear.solon.annotation.XMapping;

@XController
public class HelloworldApp {
    public static void main(String[] args) {
        XApp.start(HelloworldApp.class, args);
    }

    @XMapping("/")
    public String helloworld(){
        return "Hello world!";
    }
}

import org.noear.solon.Solon;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;

@Controller
public class HelloworldApp {
    public static void main(String[] args) {
        Solon.start(HelloworldApp.class, args);
    }

    @Mapping("/")
    public String helloworld(){
        return "Hello world!";
    }
}

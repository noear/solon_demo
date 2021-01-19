import org.noear.solon.Solon;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.core.handle.Result;


@Controller
public class HelloworldApp {
    public static void main(String[] args) {
        Solon.start(HelloworldApp.class, args);
    }

    @Mapping("/")
    public Object helloworld(){

        Result.failure();

        Result.failure(400);
        String xx= "";
        return Result.succeed(xx);
    }
}

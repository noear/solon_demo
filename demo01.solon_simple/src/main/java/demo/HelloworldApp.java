package demo;

import org.noear.solon.Solon;
import org.noear.solon.SolonApp;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.core.handle.Result;


@Controller
public class HelloworldApp {
    public static void main(String[] args) {
        SolonApp app = Solon.start(HelloworldApp.class, args);


        app.before(c->{
            if(c.header("xxx") == null){
                c.statusSet(403);
                c.setHandled(true);
            }
        });
    }

    @Mapping("/")
    public Object helloworld(){

        Result.failure();

        Result.failure(400);
        String xx= "";
        return Result.succeed(xx);
    }
}

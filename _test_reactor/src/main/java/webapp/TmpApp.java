package webapp;

import org.noear.solon.Solon;
import org.noear.solon.SolonApp;

public class TmpApp {
    public static void main(String[] args) {
        SolonApp app = Solon.start(TmpApp.class, args);


        app.get("**",(c)-> {
            c.output("test");
        });
    }
}

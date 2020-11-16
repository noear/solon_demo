package webapp;

import org.noear.solon.Solon;

public class TmpApp {
    public static void main(String[] args) {
        Solon app = Solon.start(TmpApp.class, args);


        app.get("**",(c)-> {
            c.output("test");
        });
    }
}

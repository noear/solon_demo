package dockapp;

import actuator.IActuator;
import org.noear.solon.Solon;

public class App {
    public static void main(String[] args) {
        Solon.start(App.class, args);

        IActuator tmp = Solon.context().getBean(IActuator.class);

        if(tmp == null){
            System.out.println("没有找到 IActuator 实现");
        }else{
            tmp.exec();
        }
    }
}

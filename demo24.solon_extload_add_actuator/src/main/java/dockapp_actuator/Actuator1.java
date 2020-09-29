package dockapp_actuator;

import actuator.IActuator;
import org.noear.solon.annotation.XBean;

@XBean
public class Actuator1 implements IActuator {
    @Override
    public void exec() {
        System.out.println("我是执行器:(");
    }
}

package dockapp_actuator;

import actuator.IActuator;
import org.noear.solon.annotation.Bean;

@Bean
public class Actuator1 implements IActuator {
    @Override
    public void exec() {
        System.out.println("我是体外放进来的执行器，别打我:(");
    }
}

package jobapp.controller;

import org.noear.solon.annotation.XBean;
import org.noear.solon.extend.cron4j.Job;

@XBean("job:job3")
public class Job3 implements Runnable{
    @Override
    public void run() {
        System.out.println("我是 Job3 （props）");
    }
}

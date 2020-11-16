package jobapp;

import org.noear.solon.Solon;
import org.noear.solon.extend.cron4j.EnableCron4j;
import org.noear.solon.extend.quartz.EnableQuartz;

@EnableCron4j
@EnableQuartz
public class JobApp {
    public static void main(String[] args) {
        Solon.start(JobApp.class, args);
    }
}

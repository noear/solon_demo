package jobapp;

import org.noear.solon.XApp;
import org.noear.solon.extend.cron4j.EnableCron4j;
import org.noear.solon.extend.quartz.EnableQuartz;

@EnableCron4j
@EnableQuartz
public class JobApp {
    public static void main(String[] args) {
        XApp.start(JobApp.class, args);
    }
}

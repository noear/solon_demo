package jobapp.controller;

import org.noear.solon.extend.cron4j.Cron4j;

@Cron4j(cron5x = "*/1 * * * *")
public class Job2 implements Runnable{
    @Override
    public void run() {
        System.out.println("我是 Job2 （*/1 * * * *）");
    }
}

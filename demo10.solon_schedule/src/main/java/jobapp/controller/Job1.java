package jobapp.controller;

import org.noear.solon.extend.cron4j.Cron4j;

@Cron4j(cron5x = "2s")
public class Job1  implements Runnable{
    @Override
    public void run() {
        System.out.println("我是 Job1 （2s）");
    }
}

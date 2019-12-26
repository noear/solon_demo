package jobapp.controller;

import org.noear.solon.extend.cron4j.Job;

@Job(cron4x = "*/1 * * * *")
public class Job2 implements Runnable{
    @Override
    public void run() {
        System.out.println("我是 Job2 （*/1 * * * *）");
    }
}

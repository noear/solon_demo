package jobapp.controller;

import org.noear.solon.extend.quartz.Quartz;

import java.util.Date;

@Quartz(cron7x = "2s" ,name = "QuartzRun1")
public class QuartzRun1 implements Runnable {
    @Override
    public void run() {
        System.out.println("我是定时任务: QuartzRun1(2s) -- " + new Date().toString());
        //throw new RuntimeException("异常");
        System.out.println("如果间隔太长，我可能被配置给控制了");
    }
}

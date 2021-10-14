##### （一）新建一个 maven 空项目

##### （二）添加 maven 引用
```xml
<dependency>
    <groupId>org.noear</groupId>
    <artifactId>cron4j-solon-plugin</artifactId>
    <version>1.5.45</version>
</dependency>
```

##### （三）新建代码文件
* java/jobapp/JobApp
* java/jobapp/controller/Cron4jRun1
* java/jobapp/controller/Cron4jRun2
* java/jobapp/controller/Cron4jTask
* reources/application.properties

##### （四）代码

* JobApp 代码

JobApp.java
```java
//
// 启用 Cron4j 主解的任务
//
@EnableCron4j
public class JobApp {
    public static void main(String[] args) {
        Solon.start(JobApp.class, args);
    }
}

```

* 使用快捷配置模式：n + ms,s,m,h,d ；使用Runnable接口开发

Cron4jRun1.java
```java
@Cron4j(cron5x = "2s", name = "job1")
public class Cron4jRun1 implements Runnable {
    @Override
    public void run() {
        System.out.println("我是 Cron4jRun1 （2s）");
    }
}
```

* 使用cron5x配置模式：* * * * * ；使用Runnable接口开发

Cron4jRun2.java
```java
@Cron4j(cron5x = "*/1 * * * *")
public class Cron4jRun2 implements Runnable {
    @Override
    public void run() {
        System.out.println("我是 Cron4jRun2 （*/1 * * * *）");
    }
}

```

* 使用cron5x配置模式：* * * * * ；使用Task接口开发

Cron4jTask.java
```java
@Cron4j(cron5x = "*/1 * * * *")
public class Cron4jTask extends Task {
    @Override
    public void execute(TaskExecutionContext context) throws RuntimeException 
        System.out.println("我是 Cron4jTask （*/1 * * * *）");
    }
}
```

##### （五）通过配置，控制有name的任务

application.properties
```properties
# solon.cron4j.{job name}
#
solon.cron4j.job1.cron5x=10s  #重新定义时间表达式
solon.cron4j.job1.enable=true #用任务进行启停控制
```

##### （六）运行输出
```
solon.plugin:: Start loading
file:/Users/xieyuejia/WORK/work_github/solon_demo/demo10.solon_schedule/target/classes/application.properties
jar:file:/Users/xieyuejia/.m2/repository/org/noear/cron4j-solon-plugin/1.2.20/cron4j-solon-plugin-1.2.20.jar!/solonplugin/solon.extend.cron4j.properties
我是定时任务: Cron4jRun1(200ms)）
solon.plugin:: End loading @129ms
我是定时任务: Cron4jRun1(200ms)
```

##### （六）DEMO源码
[源码：demo10.solon_schedule](https://gitee.com/noear/solon_demo/tree/master/demo10.solon_schedule)

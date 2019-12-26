# 使用 cron4j-solon-plugin 开发定时任务

##### （一）新建一个空的meven项目

##### （二）添加meven引用
```xml
<dependency>
    <groupId>org.noear</groupId>
    <artifactId>cron4j-solon-plugin</artifactId>
    <version>1.0.4</version>
</dependency>
```

##### （三）新建代码文件
* java/jobapp/JobApp
* java/jobapp/controller/Job1
* java/jobapp/controller/Job2
* java/jobapp/controller/Job3
* reources/application.properties

##### （四）代码

* JobApp 代码

JobApp.java 
```java
public class JobApp {
    public static void main(String[] args) {
        //加载配置和注解
        XApp.start(JobApp.class, args);
    }
}
```

* 注解模式，Job1，Job2（使用@Job注解）
1. cron4x，极速配置：n + ms,s,m,h,d

Job1.java
```java
@Job(cron4x = "2s")
public class Job1  implements Runnable{
    @Override
    public void run() {
        System.out.println("我是 Job1 （2s）");
    }
}
```

2. cron4x，cron4配置：* * * * *

Job2.java
```java
@Job(cron4x = "*/1 * * * *")
public class Job2 implements Runnable{
    @Override
    public void run() {
        System.out.println("我是 Job2 （*/1 * * * *）");
    }
}

```

* 配置模式：Job3（使用@XBean注解）

Job3.java
```java
//模式：@XBean("job:{job name}")
//
@XBean("job:job3")
public class Job3 implements Runnable{
    @Override
    public void run() {
        System.out.println("我是 Job3 （props）");
    }
}
```

application.properties
```properties
# solon.schedule.{job name}
#
solon.schedule.job3.cron4x=3s
solon.schedule.job3.enable=true
```


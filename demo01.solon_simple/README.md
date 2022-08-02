# Solon 最简单demo---Hello World

Solon 的项目地址：

[https://gitee.com/noear/solon](https://gitee.com/noear/solon)

里面杂七杂八的东西很多。。。今天的目标是整一个最最简单，最最小巧的 Hello world

#### （一）用 IntelliJ IDEA 新建一个 Meven 空项目 `helloworld`

#### （二）然后在 `pom.xml` 文件里添加下框架依赖

```xml
<dependencies>
    <dependency>
        <groupId>org.noear</groupId>
        <artifactId>solon.boot.jlhttp</artifactId> <!-- 这是 solon 里最小巧的启动器了，0.1m，qps有4.5万 -->
        <version>1.9.4</version>
    </dependency>
</dependencies>
```

#### （三）添加一个类 `/src/main/java/helloworld/App.java`
```java
package helloworld;

import org.noear.solon.Solon;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;

/**
 * 申明控制器
 * */
@Controller
public class App {
    public static void main(String[] args) {
        /**
         * 启动应用
         * */
        Solon.start(App.class, args);
    }

    /**
     * Http 路径映射
     * */
    @Mapping("/")
    public String hello(){
        return "Hello world!";
    }
}

```

#### （四）对着 App.java 文件，右键，选择：Run 'App.main()'

> 然后在浏览器打开：`http://localhost:8080/`
> 
> 如果有需要，用meven把它打成jar包（0.1m哦，绝对够小巧了...）


##### （五）DEMO源码
[源码：demo01.solon_simple](https://gitee.com/noear/solon_demo/tree/master/demo01.solon_simple)


##### （六）对比测试一下QPS（用笔者的电脑测：Macbook pro 2017 i7 16g）

```
#测试脚本（分别测5次，取后3次平均值）

$ wrk -t10 -c200 -d30s --latency "http://127.0.0.1:8080/"
```

|  solon boot | 大小 | QPS | spring boot  |  QPS  | 
| -------- | -------- | -------- | -------- | -------- |
| solon.boot.jlhttp (可独立运行)     | 0.1m     | 4.5万左右     | /   |    | 
| /     |      |      | spring-boot-starter-tomcat   |  3.1万左右  | 
| solon.boot.jetty (可独立运行)     | 1.8m     | 6.5万左右     | spring-boot-starter-jetty | 3.5万左右 |
| solon.boot.undertow (可独立运行)     | 4.2m     | 7.9万左右     | spring-boot-starter-undertow | 4.9万左右 |



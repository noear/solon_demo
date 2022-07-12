# 基于AIO架构smarthttp开发的完整MVC框架

> 写了篇《基于jdk自带httpserver开发的最小完整MVC框架》，就再写篇AIO的MVC

##### DEMO启动时间：0.1s（应该算少的吧？）

smart-http 是一款比较简易的 http服务器，其通信内核采用了smart-socket最新版v1.4.6。但想提供友好的WEB服务，需要很多别的功能。

通过与solon框架的融合，便可以友好的提供MVC和AOP服务：

* solon 是一个框架的壳，实现了MVC,IOC,AOP,注解,插件等等机制。把这个壳套在smart-http上，便可以为其提供mvc等能力。
* smarthttp 是对smart-http的适配，使其能套上solon这个壳；同时还可以享用solon的其它插件带来的能力，如session，json等。
* snack3 提供json和序列化支持，也足够小；已适配为solon的序列化框架之一。
* enjoy 很难再找到比它更小的模板引擎了，还快得让人想哭。


##### （一）新建一个 maven 空项目

##### （二）添加 maven 引用
```xml
<parent>
    <groupId>org.noear</groupId>
    <artifactId>solon-parent</artifactId>
    <version>1.9.2</version>
</parent>

<dependencies>
    <!-- 基于 smart-http 封装的 solon.boot -->
    <dependency>
        <groupId>org.noear</groupId>
        <artifactId>solon.boot.smarthttp</artifactId>
    </dependency>
    <!-- 一个小巧的JSON框架 -->
    <dependency>
        <groupId>org.noear</groupId>
        <artifactId>solon.serialization.snack3</artifactId>
    </dependency>
    <!-- enjoy模板引擎 -->
    <dependency>
        <groupId>org.noear</groupId>
        <artifactId>solon.view.enjoy</artifactId>
    </dependency>
    <!-- 静态文件支持 -->
    <dependency>
        <groupId>org.noear</groupId>
        <artifactId>solon.web.staticfiles</artifactId>
    </dependency>
</dependencies>
```

##### （三）添加文件
* java/webapp/controller/HelloworldController.java
* java/webapp/controller/HomeController.java
* java/webapp/model/UserModel.java
* java/webapp/widget/FooterTag.java
* java/webapp/AioApp.java
* resources/static/jinjin.htm
* resources/WEB-INF/view/helloworld.shtm （shtm，被适配为enjoy默认的后缀名）
* //不用配置

补充说明：
```
//资源路径说明（不用配置）
resources/app.properties（或 app.yml） 为应用配置文件
resources/static/ 为静态文件根目标
resources/WEB-INF/view/ 为视图文件根目标（支持多视图共存）

//模板调试模式（或加热加载模式）：
启动参数添加：-deubg=1
```

##### （四）代码

* webapp/AioApp.java
```java
public class AioApp {
    public static void main(String[] args) {
        App.start(AioApp.class, args);
    }
}
```

* webapp/widget/FooterTag.java
```java
@Component("view:footer")
public class FooterTag extends Directive {
    @Override
    public void exec(Env env, Scope scope, Writer writer) {
        StringBuffer sb = new StringBuffer();

        sb.append("<footer>");
        sb.append("我是自定义标签，FooterTag");
        sb.append("</footer>");

        try {
            writer.write(sb.toString());
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
```

* webapp/model/UserModel.java
```java
@Data
public class UserModel {
    private long id;
    private String name;
    private int sex;
    private String label;
}
```

* webapp/controller/HomeController.java
```java
@Controller
public class HomeController {
    @Produces("text/html;charset=utf-8")
    @Mapping("/")
    public String home(){
        return "<a href='/helloworld'>/helloworld</a>";
    }
}
```

* webapp/controller/HelloworldController.java
```java
@Controller
public class HelloworldController {
    @Mapping("/helloworld")
    public Object helloworld(){
        UserModel m = new UserModel();
        m.setId(10);
        m.setName("刘之西东");
        m.setSex(1);

        ModelAndView vm = new ModelAndView("helloworld.shtm");

        vm.put("title","demo");
        vm.put("message","hello world!");
        vm.put("m",m);

        return vm;
    }
}
```

* resources/WEB-INF/view/helloworld.shtm
```html
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>#(title)</title>
</head>
<body>
<div>
    #(m.name) : #(message) （我想<a href="/jinjin.htm">静静</a>）
</div>
#footer()
</body>
</html>
```

##### （五）运行 AioApp.main()
* 浏览器打开：http://localhost:8080/
* 浏览器输出：<a href='/helloworld'>/helloworld</a>


##### （六）DEMO源码
[源码：demo12.solon_aio_http_mvc](https://gitee.com/noear/solon_demo/tree/master/demo12.solon_aio_http_mvc)
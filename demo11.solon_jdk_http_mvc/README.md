# 基于jdk自带httpserver开发的最小完整MVC框架

##### 410kb级的完整MVC：solon(83k) + jdkhttp(27k) + enjoy(227k) + snack3(73k)

##### DEMO启动时间：0.1s

* solon 是一个插件框架，提供MVC,IOC,AOP,注解,插件机制。
* jdkhttp 基于jdk自带httpserver封装而成，有完整的http功能，参数，cookies，上传文件。
* snack3 提供json和序列化支持。
* enjoy 很难再找到比它更小的模板引擎了，还快得让人想哭。


##### （一）新建一个 maven 空项目

##### （二）添加 maven 引用
```xml
<dependencies>
    <dependency>
        <groupId>org.noear</groupId>
        <artifactId>solon.boot.jdkhttp</artifactId>
        <version>1.0.4</version>
    </dependency>
    <dependency>
        <groupId>org.noear</groupId>
        <artifactId>solon.serialization.snack3</artifactId>
        <version>1.0.4</version>
    </dependency>
    <dependency>
        <groupId>org.noear</groupId>
        <artifactId>solon.view.enjoy</artifactId>
        <version>1.0.4</version>
    </dependency>
</dependencies>
```

##### （三）添加文件
* java/webapp/controller/HelloworldController.java
* java/webapp/controller/HomeController.java
* java/webapp/model/UserModel.java
* java/webapp/widget/FooterTag.java
* java/webapp/JdkApp.java
* resources/static/jinjin.htm
* resources/WEB-INF/view/helloworld.shtm
* //不用配置

##### （四）代码

* webapp/JdkApp.java
```java
public class JdkApp {
    public static void main(String[] args) {
        XApp.start(JdkApp.class, args);
    }
}
```

* webapp/widget/FooterTag.java
```java
@XBean("view:footer")
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
@XController
public class HomeController {
    @XMapping(value = "/", produces = "text/html;charset=utf-8")
    public String home(){
        return "<a href='/helloworld'>/helloworld</a>";
    }
}
```

* webapp/controller/HelloworldController.java
```java
@XController
public class HelloworldController {
    @XMapping("/helloworld")
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

##### （五）运行 JdkApp.main()
* 浏览器打开：http://localhost:8080/
* 浏览器输出：<a href='/helloworld'>/helloworld</a>


##### （六）DEMO源码
[源码：demo11.solon_jdk_http_mvc](https://gitee.com/noear/solon_demo/tree/master/demo11.solon_jdk_http_mvc)
# Solon：Hello world!

##### （一）新建一个 maven 空项目

##### （二）添加 maven 引用
```xml
<dependency>
    <groupId>org.noear</groupId>
    <artifactId>solon.boot.jlhttp</artifactId>
    <version>1.5.40</version>
</dependency>
```

##### （三）添加文件
* java/HelloworldApp.java

```java
@Controller
public class HelloworldApp {
    public static void main(String[] args) {
        Solon.start(HelloworldApp.class, args);
    }

    @Mapping("/")
    public String helloworld(){
        return "Hello world!";
    }
}

```

##### （四）运行 HelloworldApp.main()
* 浏览器打开：http://localhost:8080/
* 浏览器：Hello world!


##### （五）DEMO源码
[源码：demo01.solon_tmp](https://gitee.com/noear/solon_demo/tree/master/demo01.solon_tmp)



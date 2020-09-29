**实验指南：**

1. 建个文件夹 demo24.bin，并按以下结构放好文件

```
demo24.bin/
demo24.bin/dockapp.jar
demo24.bin/dockapp_ext/
demo24.bin/dockapp_ext/dockapp.add.actuator.jar
demo24.bin/dockapp_ext/dockapp.add.http.jar
```

2. 然后通过java命令运行（支持：jdk8+）：

```
java -jar dockapp.jar  #由jar包内的配置文件，指定扩展目录

java -jar dockapp.jar --extend=xxx #通过参数，指定扩展目录
```

> 说明，dockapp_ext 文件夹名由：dockapp.jar 里的配置决定；或者在运行命令中指定；
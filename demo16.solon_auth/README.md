
## Solon Auth （solon.extend.auth） 插件示例：

Solon Auth 的定位是，暂时只做认证控制。侧重对验证结果的适配，及在此基础上的统一配置及应用。功能虽少，但用户不会晕。

#### 一、完成2步适配动作

* 构建一个认证适配器

```java
@Configuration
public class Config {
    @Bean
    public AuthAdapter init() {
        //
        // 构建适配器
        //
        return new AuthAdapter()
                .loginUrl("/login") //设定登录地址，未登录时自动跳转（如果不设定，则输出401错误）
                .addRule(r -> r.include("**").verifyIp().failure((c, t) -> c.output("你的IP不在白名单"))) //添加规则
                .addRule(b -> b.exclude("/login**").exclude("/run/**").verifyPath()) //添加规则
                .processor(new AuthProcessorImpl()) //设定认证处理器
                .failure((ctx, rst) -> { //设定默认的验证失败处理
                    ctx.render(rst);
                });
    }
}

//规则配置说明
//1.include(path) 规则包函的路径范围，可多个
//2.exclude(path) 规则排序的路径池围，可多个
//3.failure(..)   规则失则后的处理
//4.verifyIp()... 规则要做的验证方案（可多个不同的验证方案）

```

* 实现一个认证处理器 

```java
public class AuthProcessorImpl implements AuthProcessor {
    //具体看一下项目里的代码
}
```

AuthProcessor 对接的是一系列的验证动作结果。相对来说比较直观，同时自己也得多干点活。

#### 二、2种应用方式（一般组合使用）

* 第1种，在 AuthAdapter 直接配置所有规则，或部分规则（可以没有）

```java
//参考上面的适配器 addRule(...)
```

配置的好处是，不需要侵入业务代码；同时在统一的地方，宏观可见；但容易忽略掉细节。

* 第2种，基于注解做一部份（一般特定权限 或 特定角色时用）

```java
@Mapping("/rock/agroup")
@Controller
public class AgroupController {
    @Mapping("")
    public void home() {
        //agroup 首页
    }

    @Mapping("inner")
    public void inner() {
        //内部列表页
    }

    
    @AuthPermissions("agroup:edit")
    @Mapping("edit/{id}")
    public void edit(int id) {
        //编辑显示页，需要编辑权限
    }

    @AuthRoles("admin")
    @Mapping("edit/{id}/ajax/save")
    public void save(int id) {
        //编辑处理接口，需要管理员权限
    }
}
```

注解的好处是，微观可见，在一个方法上就可以看到它需要什么权限或角色，不容易忽略。

* 组合使用方式

一般，用`配置规则`，控制所有需要登录的地址；用`注解`，控制特定的权限或角色。

#### 三、附：真实项目应用

[https://gitee.com/noear/water/tree/master/wateradmin](https://gitee.com/noear/water/tree/master/wateradmin)

[https://gitee.com/noear/sponge/tree/main/spongeadmin](https://gitee.com/noear/sponge/tree/main/spongeadmin)

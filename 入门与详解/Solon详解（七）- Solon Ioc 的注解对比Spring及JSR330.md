### 注解对比

|  Solon 1.1 | Spring | JSR 330 | |
| -------- | -------- | -------- | -------- |
| @Inject *     | @Autowired     | @Inject     | 注入Bean（by type）    |
| @Inject("name")     | @Qualifier+@Autowired     | @Qualifier+@Inject     | 注入Bean（by name）    |
| @Inject("${name}")     | @Value("${name}")     | -     | 注入配置    |
| @Bean *     | @Component     | @Named     | 托管Bean     |
| @Singleton     | @Scope(“singleton”)     | @Singleton     | 单例（Solon 默认是单例）     |
| @Singleton(false)     | @Scope(“prototype”)     | -     | 非单例     |
| | | |
| @XInit *     | @PostConstruct     | -     | 构造完成并注入后的初始化     |
| @Configuration | @Configuration | - | 配置类 |
| @Controller | @Controller,@RestController | - | 控制器类 |
| @Mapping | @RequestMapping,@GetMapping... | - | 映射 |


* Solon 的 @Inject 算是： Spring 的@Value、@Autowired、@Qualifier 三者的结合，但又不完全等价
* Solon 托管的 Bean 初始化顺序：new() - > @Inject - > @XInit -> Method@Bean
* 注1：Method@Bean，只执行一次（只在 @Configuration 里有效）
* 注2：@Inject 的参数注入，只在Method@Bean上有效
* 注3：@Inject 的类型注入，只在@Configuration类上有效

### 部分用例说明

> Solon 强调有节制的注解使用，尤其对于增加处理链路的操会比较节制。

* @Bean（Bean的托管：基于 name 或者 类型；且只记录第一次的注册）

```java
@Bean
public class UserService{
    @Db("db1")    //@Db为第三方扩展的注入注解
    BaseMapper<User> mapper;
    
    UserModel getUser(long puid){
        return db1.selectById(puid);
    }
}

/* @Bean("userService")
public class UserService{
    @Db("db1") 
    BaseMapper<User> mapper;
    
    UserModel getUser(long puid){
        return db1.selectById(puid);
    }
} */
```

* @Controller

```
@Singleton(false)    //非单例注解
@Controller
public class UserController{
    @Inject("${message.notnull}")
    String message;
    
    @Inject
    UserService userService
    
    @Mapping("/user/{puid}")
    public Object user(Long puid){
        if(puid == null){
            return message;
        }
        return userService.getUser(puid);
    }
}
```

* @Configuration

```java
@Configuration
public class Config {
    @Bean("db1")
    public DataSource db1(@Inject("${test.db1}") HikariDataSource ds) {
        return ds;
    }
}

//系统异常监听（这个系统会发的，还可以监听不同的异常）
//
@Configuration
public class ThrowableListener implements XEventListener<Throwable> {
    WaterLogger log = new WaterLogger("rock_log");

    @Override
    public void onEvent(Throwable err) {
        XContext ctx = XContext.current();

        if (ctx != null) {
            String _in = ONode.stringify(ctx.paramMap());

            log.error(ctx.path(), _in, err);
        }
    }
}

//Bean扩展监听（为Mybatis配置类，添加插件）
//
@Configuration
public class  SqlHelperMybatisAutoConfiguration implements XEventListener<Configuration> {

    //...
    
    @Override
    public void onEvent(Configuration configuration) {
       SqlHelperMybatisPlugin plugin = new SqlHelperMybatisPlugin();
       //...
       configuration.addInterceptor(plugin);
    }    
}
```

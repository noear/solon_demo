package demo;

import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Configuration;
import org.noear.solon.annotation.Inject;
import org.noear.solon.cache.jedis.RedisCacheService;
import org.noear.solon.cache.spymemcached.MemCacheService;
import org.noear.solon.data.cache.CacheService;

/**
 * @author noear 2021/5/12 created
 */
@Configuration
public class Config {
    @Bean
    public CacheService cache(@Inject("${cache1}") MemCacheService cache){
        return cache;
    }

//    @Bean
//    public CacheService cache2(@Inject("${cache2}") RedisCacheService cache){
//        return cache;
//    }
}

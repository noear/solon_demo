package demo;

import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Configuration;
import org.noear.solon.annotation.Inject;
import org.noear.solon.cache.spymemcached.MemCacheService;
import org.noear.solon.core.cache.CacheService;

/**
 * @author noear 2021/5/12 created
 */
@Configuration
public class Config {
    @Bean
    public CacheService cache(@Inject("${cache1}") MemCacheService cache){
        return cache;
    }
}

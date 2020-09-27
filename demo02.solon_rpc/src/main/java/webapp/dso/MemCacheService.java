package webapp.dso;

import org.noear.solon.core.CacheService;
import org.noear.weed.cache.memcached.MemCache;

import java.util.Properties;

public class MemCacheService implements CacheService {
    MemCache memCache;
    public MemCacheService(Properties prop){
        memCache = new MemCache(prop);
    }

    @Override
    public void store(String key, Object obj, int seconds) {
        memCache.store(key,obj,seconds);
    }

    @Override
    public Object get(String key) {
        return memCache.get(key);
    }

    @Override
    public void remove(String key) {
        memCache.remove(key);
    }
}

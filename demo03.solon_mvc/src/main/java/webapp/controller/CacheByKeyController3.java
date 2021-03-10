package webapp.controller;

import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.extend.data.annotation.Cache;
import org.noear.solon.extend.data.annotation.CachePut;
import org.noear.solon.extend.data.annotation.CacheRemove;

import java.time.LocalDateTime;
import java.util.Date;

@Controller
public class CacheByKeyController3 {
    /**
     * 执行结果缓存10秒，并添加 test_${label} 和 test1 标签
     */
    @Cache(key = "test3_${label}", seconds = 600)
    @Mapping("/cache3/")
    public String cache(int label) {
        return LocalDateTime.now().toString();
    }

    @Cache(key = "test3", seconds = 600)
    @Mapping("/cache3/cache2")
    public String cache2() {
        return LocalDateTime.now().toString();
    }


    /**
     * 执行后，清除 标签为 test_${label}  的缓存
     */
    @CachePut(key = "test3_${label}")
    @CacheRemove(keys = "test2")
    @Mapping("/cache3/update")
    public String remove(int label) {
        return "清除成功-" + new Date();
    }
}

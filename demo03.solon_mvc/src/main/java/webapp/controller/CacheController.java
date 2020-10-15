package webapp.controller;

import org.noear.solon.annotation.*;

import java.util.Date;

@XController
public class CacheController {
    /**
     * 执行结果缓存10秒，并添加 test_${label} 和 test1 标签
     * */
    @XCache(tags = "test_${label},test1" , seconds = 60)
    @XMapping("/cache/")
    public Date test(int label) {
        return new Date();
    }

    /**
     * 执行后，清除 标签为 test  的缓存（不过，目前没有 test 的示签...）
     * */
    @XCachePut(tags = "test1")
    @XMapping("/cache/update")
    public Date update() {
        return new Date();
    }

    /**
     * 执行后，清除 标签为 test_${label}  的缓存
     * */
    @XCacheRemove(tags = "test_${label}")
    @XMapping("/cache/remove")
    public String remove(int label) {
        return "清除成功-" + new Date();
    }
}

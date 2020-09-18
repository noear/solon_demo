package webapp.controller;

import org.noear.solon.annotation.XCachePut;
import org.noear.solon.annotation.XCacheRemove;
import org.noear.solon.annotation.XController;
import org.noear.solon.annotation.XMapping;

import java.util.Date;

@XController
public class CacheController {
    /**
     * 执行结果缓存10秒，并添加 test_${label} 和 test1 标签
     * */
    @XCachePut(tags = "test_${label},test1" , seconds = 10)
    @XMapping("/cache/")
    public Object test(int label) {
        return new Date();
    }

    /**
     * 执行后，清除 标签为 test  的缓存（不过，目前没有 test 的示签...）
     * */
    @XCacheRemove(tags = "test")
    @XMapping("/cache/clear")
    public String clear() {
        return "清除成功(其实无效)-" + new Date();
    }

    /**
     * 执行后，清除 标签为 test_${label}  的缓存
     * */
    @XCacheRemove(tags = "test_${label}")
    @XMapping("/cache/clear2")
    public String clear2(int label) {
        return "清除成功-" + new Date();
    }
}

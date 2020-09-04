package webapp.controller;

import org.noear.solon.annotation.XCache;
import org.noear.solon.annotation.XController;
import org.noear.solon.annotation.XMapping;

import java.util.Date;

@XController
public class CacheController {
    @XCache(tags = "test_${label}" , seconds = 10)
    @XMapping("/cache/")
    public Object test(int label) {
        return new Date();
    }

    @XCache(clearTags = "test")
    @XMapping("/cache/clear")
    public String clear() {
        return "清除成功(其实无效)-" + new Date();
    }

    @XCache(clearTags = "test_${label}")
    @XMapping("/cache/clear2")
    public String clear2(int label) {
        return "清除成功-" + new Date();
    }
}

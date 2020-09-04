package webapp.controller;

import org.noear.solon.annotation.XCache;
import org.noear.solon.annotation.XController;
import org.noear.solon.annotation.XMapping;

import java.util.Date;

@XController
public class CacheController {
    @XCache(tags = "test" , seconds = 10)
    @XMapping("/cache/")
    public Object test() {
        return new Date();
    }

    @XCache(clearTags = "test")
    @XMapping("/cache/clear")
    public String clear() {
        return "清除成功-" + new Date();
    }
}

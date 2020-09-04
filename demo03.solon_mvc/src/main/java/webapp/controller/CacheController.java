package webapp.controller;

import org.noear.solon.annotation.XCache;
import org.noear.solon.annotation.XController;
import org.noear.solon.annotation.XMapping;

@XController
public class CacheController {
    @XCache(seconds = 10)
    @XMapping("/cache/")
    public String test() {
        return "ddd";
    }
}

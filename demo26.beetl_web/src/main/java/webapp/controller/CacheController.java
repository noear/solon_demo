package webapp.controller;

import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.extend.data.annotation.Cache;
import org.noear.solon.extend.data.annotation.CacheRemove;

import java.util.Date;

@Controller
public class CacheController {
    /**
     * 执行结果缓存10秒，并添加 test_${label} 和 test1 标签
     * */
    @Cache(tags = "test_${label},test1" , seconds = 10)
    @Mapping("/cache/")
    public Object test(int label) {
        return new Date();
    }

    /**
     * 执行后，清除 标签为 test  的缓存（不过，目前没有 test 的示签...）
     * */
    @CacheRemove(tags = "test")
    @Mapping("/cache/clear")
    public String clear() {
        return "清除成功(其实无效)-" + new Date();
    }

    /**
     * 执行后，清除 标签为 test_${label}  的缓存
     * */
    @CacheRemove(tags = "test_${label}")
    @Mapping("/cache/clear2")
    public String clear2(int label) {
        return "清除成功-" + new Date();
    }
}

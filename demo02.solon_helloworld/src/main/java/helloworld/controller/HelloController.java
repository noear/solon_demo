package helloworld.controller;

import org.noear.solon.annotation.XController;
import org.noear.solon.annotation.XMapping;
import org.noear.solon.core.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@XController
public class HelloController {
    /**
     * 这是直接返回值
     * */
    @XMapping("/")
    public String hello() {
        return "Hello world!";
    }

    /**
     * 这是返回个对象（以json形式）
     * */
    @XMapping("/")
    public Map hello_json() {
        Map<String,Object> map = new HashMap<>(); //实体也ok
        map.put("message", "Hello world!");

        return map;
    }

    /**
     * 这是用 FreeMarker 进行渲染（你想用别的引擎？可以随便换，比如：Enjoy）
     * */
    @XMapping("/ftl")
    public ModelAndView hello_ftl() {
        ModelAndView mv = new ModelAndView("hello.ftl");
        mv.put("message", "Hello world!");

        return mv;
    }
}
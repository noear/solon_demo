package server;

import client.ComplexModelService;
import org.noear.solon.XApp;
import org.noear.solon.annotation.XMapping;
import org.noear.solon.core.Aop;
import org.noear.solon.serialization.hession.HessianHandler;

public class ServerApp {
    public static void main(String[] args) {
        XApp app = XApp.start(ServerApp.class, args);

        //手动添加
//        app.http("/test/", new HessianHandler(ComplexModelService.class, new ComplexModelServiceImpl()));

        //自动批量添加（下次把这个写成插件好了）
        Aop.beanForeach((key, beanWrap) -> {
            if ("hessian".equals(beanWrap.tag())) {
                XMapping m1 = beanWrap.clz().getAnnotation(XMapping.class);
                if (m1 != null) {
                    HessianHandler h1 = new HessianHandler(beanWrap.clz().getInterfaces()[0], beanWrap.get());
                    app.http(m1.value(), h1);
                }
            }
        });
    }
}

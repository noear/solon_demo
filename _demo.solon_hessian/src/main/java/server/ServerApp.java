package server;

import org.noear.solon.Solon;
import org.noear.solon.core.Aop;
import org.noear.solon.core.handle.MethodType;
import server.controller.ComplexModelService;
import server.dso.IComplexModelService;
import server.wrap.HessianHandler;
import server.dso.IGreetingService;

public class ServerApp {
    public static void main(String[] args) {
        Solon.start(ServerApp.class, args);

        Solon.global().add("/web/hessian", MethodType.HTTP,
                new HessianHandler(IGreetingService.class, Solon.context().getBean(IGreetingService.class)));


        Solon.global().add("/web/hessian_complex", MethodType.HTTP,
                new HessianHandler(IComplexModelService.class, Solon.context().getBean(ComplexModelService.class)));

        //HessianServlet
    }
}

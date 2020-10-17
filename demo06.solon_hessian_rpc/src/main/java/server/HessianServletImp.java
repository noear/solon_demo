package server;

import client.ComplexModelService;
import com.caucho.hessian.server.HessianServlet;
import org.noear.solon.core.Aop;

import javax.servlet.annotation.WebServlet;

@WebServlet(value = "/test/")
public class HessianServletImp extends HessianServlet {
    public HessianServletImp(){
        setHomeAPI(ComplexModelService.class);
        setHome(Aop.get(ComplexModelServiceImpl.class));
    }
}

package client;

import client.model.ComplexModel;
import client.model.Person;
import client.model.Point;
import com.caucho.hessian.client.HessianProxyFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClientApp {
    public static void main(String[] args) throws Throwable{
        //RPC访问地址
        String url = "http://localhost:8080/test/";

        //接口的动态代理工厂
        HessianProxyFactory factory = new HessianProxyFactory();
        ComplexModelService service = (ComplexModelService) factory.create(ComplexModelService.class, url);

        ComplexModel<Point> model = buildModel();

        //调用1：
        service.save(model);

        //调用2：
        model = service.read(model.getId());

        List<Point> points1 = model.getPoints();
        for(Point elem : points1) {
            System.out.println(elem.getX() + "\t" + elem.getY());
        }
    }

    private static ComplexModel<Point> buildModel(){
        ComplexModel<Point> model = new ComplexModel<Point>();
        model.setId(1);
        Person person = new Person();
        person.setName("Tom");
        person.setAge(86);
        person.setBirthDay(new Date());
        person.setSensitiveInformation("This should be private over the wire");
        model.setPerson(person);

        List<Point> points = new ArrayList<Point>();
        Point point = new Point();
        point.setX(3);
        point.setY(4);
        points.add(point);

        point = new Point();
        point.setX(100);
        point.setY(100);
        points.add(point);

        //远程方法调用
        model.setPoints(points);

        return model;
    }
}

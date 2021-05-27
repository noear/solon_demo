package demo2;

import demo.UserDO;
import org.bson.Document;
import org.junit.Test;
import org.noear.solon.Utils;
import org.noear.weed.mongo.MgContext;

import java.util.List;
import java.util.Map;

/**
 * @author noear 2021/2/5 created
 */
public class MongoTest2 {
    String url = "mongodb://172.168.0.162:27017";

    MgContext db = new MgContext(url, "demo");

    @Test
    public void test1() {
        db.table("user")
                .set("_id", Utils.guid())
                .set("id", System.currentTimeMillis())
                .set("name", "noear")
                .insert();
    }

    @Test
    public void test2() {
        db.table("user")
                .set("_id", Utils.guid())
                .set("id", 3)
                .set("type",1)
                .set("name", "noear")
                .insert();

        db.table("user")
                .set("_id", Utils.guid())
                .set("id", 5)
                .set("type",1)
                .set("name", "noear")
                .insert();
    }

    @Test
    public void test3() {
        db.table("user")
                .set("name", "noear-update")
                .whereEq("id", 5).andLk("name","^/no")
                .update();
    }

    @Test
    public void test4() {
        Map map =  db.table("user")
                .whereEq("id", 5).andEq("type",1)
                .selectMap();

        System.out.println(map);
    }

    @Test
    public void test42() {
        UserDO user =  db.table("user")
                .whereEq("id", 5).andEq("type",1)
                .selectItem(UserDO.class);

        System.out.println(user);
    }

    @Test
    public void test5() {
        List<Document> mapList =  db.table("user")
                .whereEq("type",1)
                .orderByAsc("id")
                .selectMapList();

        System.out.println(mapList);
    }

    @Test
    public void test52() {
        List<UserDO> mapList =  db.table("user")
                .whereEq("type",1)
                .orderByAsc("id")
                .limit(10,10)
                .selectList(UserDO.class);

        System.out.println(mapList);
    }
}

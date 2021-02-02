package demo;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Sorts;
import com.mongodb.client.model.Updates;
import org.bson.conversions.Bson;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @author noear 2021/2/1 created
 */
public class MongoTest {
    String serverIp = "172.168.0.162";
    int serverPort = 27017;

    /**
     * 获取集合
     *
     * @param dbName
     * @param collection
     * @return
     */
    public MongoCollection<UserDO> getCollection(String dbName, String collection) {
        MongoClient dbSource = new MongoClient(serverIp, serverPort);
        MongoDatabase db = dbSource.getDatabase(dbName);

        dbSource.close();
        return db.getCollection(collection, UserDO.class);
    }

    @Test
    public void insert() {
        UserDO userDO = new UserDO();
        userDO.setId(1);
        userDO.setName("noear");
        userDO.setNickname("noear2");

        MongoCollection<UserDO> collection = getCollection("test2", "user");
        //collection.insertMany(new ArrayList<UserDO>());
        collection.insertOne(userDO);
    }

    @Test
    public void queryUpdateDelete() {
        MongoCollection<UserDO> collection = getCollection("test2", "user");
        //查
        Bson midCondition = Filters.and(Filters.eq("field1", "value1"), Filters.lt("field2", "value2"));
        Bson condition = Filters.or(Filters.in("filed3", new ArrayList<>()), midCondition);
        FindIterable<UserDO> result = collection.find(condition).sort(Sorts.orderBy(Sorts.descending("filed4"), Sorts.ascending("filed5")));
        UserDO firstUser = result.first();
        //删
        collection.deleteOne(Filters.eq("id", firstUser.getId()));
        //改
        for (UserDO user : result) {
            collection.updateOne(Filters.eq("id", user.getId()), Updates.set("displayName", "张三"));
        }
    }
}

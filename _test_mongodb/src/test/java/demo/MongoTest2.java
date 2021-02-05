package demo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.junit.Test;
import org.noear.solon.Utils;

/**
 * @author noear 2021/2/1 created
 */
public class MongoTest2 {
    String serverIp = "172.168.0.162";
    int serverPort = 27017;

    public MongoCollection<Document> getCollection(String dbName, String collection) {
        MongoClient dbSource = new MongoClient(serverIp, serverPort);
        MongoDatabase db = dbSource.getDatabase(dbName);

        return db.getCollection(collection);
    }

    @Test
    public void test1() {

        //db.createCollection("user");
        MongoCollection<Document> coll = getCollection("demo", "user");

        Document filter = new Document();
        filter.append("id",1);
        coll.createIndex(filter);

        Document document = new Document();
        document.append("_id", Utils.guid());
        document.append("id", System.currentTimeMillis());
        document.append("name", "noear");
        coll.insertOne(document);
    }

    @Test
    public void test2() {

        //db.createCollection("user");
        MongoCollection<Document> coll = getCollection("demo", "user");

        Document document = new Document();
        document.append("_id", Utils.guid());
        document.append("id", 3);
        document.append("name", "noear");
        coll.insertOne(document);
    }

    @Test
    public void test3() {

        //db.createCollection("user");
        MongoCollection<Document> coll = getCollection("demo", "user");



        Document filter = new Document();
        filter.append("id", 5);


        Document data = new Document();
        //newDoc.append("_id", "4cc5d1a21ca7447ca173305ed556d697");
        data.put("id", 5);
        data.put("name", "noear-update");
        //newDoc.append("level",1);

        Document newDoc = new Document();
        newDoc.put("$set", data);

        coll.updateOne(filter, newDoc);
    }

}
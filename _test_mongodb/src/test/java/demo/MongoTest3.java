package demo;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.junit.Test;

/**
 * @author noear 2021/2/1 created
 */
public class MongoTest3 {

    String serverIp = "172.168.0.162";
    int serverPort = 27017;

    public MongoCollection<Document> getCollection(String dbName, String collection) {
        MongoClient dbSource = new MongoClient(serverIp, serverPort);
        MongoDatabase db = dbSource.getDatabase(dbName);

        dbSource.close();
        return db.getCollection(collection);
    }


    @Test
    public void test2(){

        MongoCollection<Document> coll = getCollection("demo", "user");

        FindIterable<Document> list = coll.find();

        for(Document doc : list){
            System.out.println(doc);
        }
    }

    @Test
    public void test3(){

        MongoCollection<Document> coll = getCollection("demo", "user");


        Document filter = new Document();
        filter.append("_id","5681d75d3f444e2c840e6be10ee27f5f");

        FindIterable<Document> list = coll.find(filter);

        for(Document doc : list){
            System.out.println(doc);
        }
    }

    @Test
    public void test4(){

        MongoCollection<Document> coll = getCollection("demo", "user");


        Document filter = new Document();
        filter.append("id",1);

        FindIterable<Document> list = coll.find(filter);

        for(Document doc : list){
            System.out.println(doc);
        }
    }
}

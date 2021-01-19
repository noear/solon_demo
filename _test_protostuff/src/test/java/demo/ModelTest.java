package demo;

import demo.model.App;
import io.protostuff.LinkedBuffer;
import io.protostuff.ProtobufIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class ModelTest {
    private static final Schema<App> APP_SCHEMA = RuntimeSchema.getSchema(App.class);

    @Test
    public void test1() {
        //
        // 序列化
        //
        App app = new App();
        app.setId("11");
        app.setChannel_id("22");
        app.setVersion(33);
        app.setPackageName("x.x.x");

        byte[] bytes = ProtobufIOUtil.toByteArray(app, APP_SCHEMA, LinkedBuffer.allocate());

        //
        // 反序列化
        //
        App app2 = APP_SCHEMA.newMessage();
        ProtobufIOUtil.mergeFrom(bytes, app2, APP_SCHEMA);

        assert app2.getId().equals(app.getId()) ;
    }

    @Test
    public void test2() {
        //
        // 序列化
        //
        App app = new App();
        app.setId("11");
        app.setChannel_id("22");
        app.setVersion(33);
        app.setPackageName("x.x.x");

        byte[] bytes = ProtostuffUtil.serialize(app);

        //
        // 反序列化
        //
        App app2 = ProtostuffUtil.deserialize(bytes, App.class);

        assert app2.getId().equals(app.getId());
    }


    @Test
    public void test3() {
        //
        // 序列化
        //
        App app = new App();
        app.setId("11");
        app.setChannel_id("22");
        app.setVersion(33);
        app.setPackageName("x.x.x");

        Map<String,Object> map = new HashMap<>();
        map.put("app",app);

        byte[] bytes = ProtostuffUtil.serialize(map);

        //
        // 反序列化
        //
        Map<String,Object> map2 = ProtostuffUtil.deserialize(bytes, Map.class);

        assert map.size() == map2.size();
    }
}

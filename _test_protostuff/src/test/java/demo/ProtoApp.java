package demo;

import demo.model.App;
import io.protostuff.LinkedBuffer;
import io.protostuff.ProtobufIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class ProtoApp {
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

        byte[] bytes = ProtostuffUtil.serializer(app);

        //
        // 反序列化
        //
        App app2 = ProtostuffUtil.deserializer(bytes, App.class);

        assert app2.getId().equals(app.getId());
    }
}

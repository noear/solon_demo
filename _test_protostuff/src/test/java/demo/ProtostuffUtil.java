package demo;

import io.protostuff.LinkedBuffer;
import io.protostuff.ProtostuffIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;

/**
 * @author noear 2021/1/17 created
 */
public class ProtostuffUtil {
    private static final Schema<DataWrapper> WRAPPER_SCHEMA = RuntimeSchema.createFrom(DataWrapper.class);


    //序列化对象
    public static <T> byte[] serialize(T obj) {
        LinkedBuffer buffer = LinkedBuffer.allocate();

        try {
            Object serializerObj = DataWrapper.builder(obj);
            Schema schema = WRAPPER_SCHEMA;

            return ProtostuffIOUtil.toByteArray(serializerObj, schema, buffer);
        } catch (Exception e) {
            throw new IllegalStateException(e.getMessage());
        } finally {
            buffer.clear();
        }
    }


    public static <T> T deserialize(byte[] data, Class<T> clazz) {
        try {
            DataWrapper<T> wrapper = new DataWrapper<>();
            ProtostuffIOUtil.mergeFrom(data, wrapper, WRAPPER_SCHEMA);
            return wrapper.getData();
        } catch (Exception e) {
            throw new IllegalStateException(e.getMessage(), e);
        }
    }


    //静态内部类
    public static class DataWrapper<T> {
        //泛型的使用
        private T data;

        //建造者模式(返回实体类型)
        public static <T> DataWrapper<T> builder(T data) {
            DataWrapper<T> wrapper = new DataWrapper<T>();
            wrapper.setData(data);
            return wrapper;
        }

        public void setData(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }
    }
}

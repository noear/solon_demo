package demo;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author noear 2021/1/17 created
 */
public class TypeTest {
    public <T> void testDo(T val) {
        byte[] bytes = ProtostuffUtil.serialize(val);

        T val2 = ProtostuffUtil.deserialize(bytes, (Class<T>) val.getClass());

        System.out.println("val2=" + val2);

        assert val2.equals(val);
    }

    @Test
    public void test1() {
        testDo("hello");
    }

    @Test
    public void test2() {
        testDo(new Date());
    }

    @Test
    public void test3() {
        testDo(true);
        testDo(false);
    }

    @Test
    public void test4() {
        testDo(3);
        testDo(12L);
        testDo(10.3D);

        testDo(BigDecimal.valueOf(124));
    }
}

package demo;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;

import demo.impl.UserModel;
import demo.impl.UserService;
import org.junit.Test;

import java.util.List;

/**
 * @author noear 2021/4/14 created
 */

public class DemoTest {
    @Test
    public void test(){
        //create mock
        List mockedList = mock(List.class);

        //use mock object
        mockedList.add("one");
        mockedList.clear();

        //验证add方法是否在前面被调用了一次，且参数为“one”。clear方法同样。
        verify(mockedList).add("one");
        verify(mockedList).clear();

        //下面的验证会失败。因为没有调用过add("two")。
        assert false == verify(mockedList).add("two");
    }



    @Test
    public void test2(){
        UserService userService = mock(UserService.class);

        when(userService.get(12)).thenReturn(mock(UserModel.class));

        UserModel tmp = userService.get(12);

        System.out.println(tmp.toString());

        assert tmp.uid != 0;
    }
}

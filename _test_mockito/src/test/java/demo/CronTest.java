package demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.noear.solon.annotation.Inject;
import org.noear.solon.test.SolonJUnit4ClassRunner;

/**
 * @author noear 2021/4/14 created
 */
@RunWith(SolonJUnit4ClassRunner.class)
public class CronTest {

    @Inject
    CronUtil cronUtil;

    @Test
    public void xxx(){
        CronUtil.CustomCronField tmp = cronUtil.parseCon("1/* * * * * *");

        System.out.println(tmp.toString());
    }
}

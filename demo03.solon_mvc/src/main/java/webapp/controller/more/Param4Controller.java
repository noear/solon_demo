package webapp.controller.more;

import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;
import webapp.model.UserModel;

import java.io.IOException;

/**
 * @author noear 2020/12/20 created
 */

@Mapping("/demo2/param4")
@Controller
public class Param4Controller {

    @Mapping("json")
    public UserModel test_json(UserModel user) throws IOException {
        return user;
    }

    @Mapping("param")
    public UserModel test_param(UserModel user) throws IOException {
        return user;
    }
}

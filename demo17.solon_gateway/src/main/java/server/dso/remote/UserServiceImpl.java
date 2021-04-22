package server.dso.remote;

import common.UserModel;
import common.UserService;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.core.handle.Result;

/**
 * @author noear 2021/4/22 created
 */
@Mapping("user")
@Component(tag="api")
public class UserServiceImpl implements UserService {
    @Override
    public Result<UserModel> getUser() {
        UserModel user = new UserModel();
        user.setUserId(12);
        user.setNickname("noear");

        return Result.succeed(user);
    }
}

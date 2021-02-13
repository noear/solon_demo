package demo;

import io.jsonwebtoken.Claims;
import org.junit.Test;
import webapp.model.User;
import webapp.utils.JwtUtils;

public class JwtUtilTest {
    @Test
    public void testGeneJwt() {
        User user = new User();
        user.setId(999);
        user.setHeadImg("I'm busy");
        user.setName("Rookie");
        String token = JwtUtils.getJwt(user);

        System.out.println(token);
    }

    @Test
    public void testCheck() {
        // 下面此 token 字符串是上面的结果生成的，每次不一样，不是写死的
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJSb29raWVMaSIsImlkIjo5OTksIm5hbWUiOiJSb29raWUiLCJpbWciOiJJJ20gYnVzeSIsImlhdCI6MTU5OTcyMzg1NiwiZXhwIjoxNjAwMzI4NjU2fQ.b83hvcgTClyGBnRipUMrvkZUgHPCe_jVfowMbMA__rk";
        Claims claims = JwtUtils.chekcJwt(token);

        if (claims != null) {
            String name = (String) claims.get("name");
            String img = (String) claims.get("img");
            int id = (Integer) claims.get("id");
            System.out.println(name);
            System.out.println(img);
            System.out.println(id);
        } else {
            System.out.println("非法token");
        }
    }
}

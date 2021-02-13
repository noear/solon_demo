package demo;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import org.junit.Test;
import webapp.model.User;
import webapp.utils.JwtUtils;

import java.security.Key;
import java.util.Base64;

public class JwtUtilTest {


    @Test
    public void testGeneJwt() {
        Key key = buildKey();

        User user = new User();
        user.setId(999);
        user.setHeadImg("I'm busy");
        user.setName("Rookie");
        String token = JwtUtils.getJwt(user, key);

        System.out.println(token);
    }

    @Test
    public void testCheck() {
        Key key = buildKey();

        // 下面此 token 字符串是上面的结果生成的，每次不一样，不是写死的
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJSb29raWVMaSIsImltZyI6IkknbSBidXN5IiwibmFtZSI6IlJvb2tpZSIsImlzcyI6InNvbG9uIiwiaWQiOjk5OSwiZXhwIjoxNjEzODA0MjA3LCJpYXQiOjE2MTMxOTk0MDd9.QUJNajtuDC3XocE4ee2mR1PwD8XZNF6CXbT5C3yzpVs";
        Claims claims = JwtUtils.chekcJwt(token, key);

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

    public Key buildKey() {
        String secretString = "LH1w5GoNtjG7Z4yAR4I1cmF0Vvl7g769KqCcYxLNL8c=";

        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretString));
    }

    @Test
    public void createKey() {
        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

        String secretString = Encoders.BASE64.encode(key.getEncoded());

        System.out.println(secretString);
    }
}

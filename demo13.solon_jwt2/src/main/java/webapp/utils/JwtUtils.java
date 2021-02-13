package webapp.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import org.noear.solon.Utils;
import webapp.model.User;

import java.security.Key;
import java.util.Date;

public class JwtUtils {
    public static final String SUBJECT = "RookieLi";

    public static final long EXPIRE = 1000 * 60 * 60 * 24 * 7;  //过期时间，毫秒，一周

    public static String getJwt(User user, Key key) {
        if(user == null || user.getId() == null || user.getName() == null || user.getHeadImg() == null) {
            return null;
        }

        String token = Jwts.builder()
                .claim("id", user.getId())
                .claim("name", user.getName())
                .claim("img", user.getHeadImg())
                .setIssuer("solon")
                .setAudience("app.client")
                .setSubject(SUBJECT)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
                .setId(Utils.guid())
                .signWith(key).compact();

        return token;
    }
    public static Claims chekcJwt(String token, Key key) {
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

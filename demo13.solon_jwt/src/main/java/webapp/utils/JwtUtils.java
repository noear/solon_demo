package webapp.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import webapp.model.User;

import java.util.Date;

public class JwtUtils {
    public static final String SUBJECT = "RookieLi";
    public static final String SECRETKEY = "Rookie666"; // 密钥

    public static final long EXPIRE = 1000 * 60 * 60 * 24 * 7;  //过期时间，毫秒，一周

    public static String getJwt(User user) {
        if(user == null || user.getId() == null || user.getName() == null || user.getHeadImg() == null) {
            return null;
        }

        String token = Jwts.builder()
                .setSubject(SUBJECT)
                .claim("id", user.getId())
                .claim("name", user.getName())
                .claim("img", user.getHeadImg())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
                .signWith(SignatureAlgorithm.HS256, SECRETKEY).compact();

        return token;
    }
    public static Claims chekcJwt(String token) {
        try {
            final Claims claims = Jwts.parser().setSigningKey(SECRETKEY).parseClaimsJws(token).getBody();
            return claims;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

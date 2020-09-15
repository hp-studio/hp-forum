package com.hpstudio.gateway.login.util;

import com.hpstudio.gateway.entity.User;
import io.jsonwebtoken.*;

import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

/**
 * @author mawen
 * @date 2020/9/10 14:23
 * @email 455766076@qq.com
 */
public class JwtUtil {


    public static String createJWT(long ttlMillis, User user) {
        //指定签名算法
        SignatureAlgorithm hs256 = SignatureAlgorithm.HS256;

        //生成jwt时间
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        //payload的私有声明
        HashMap<String, Object> claims = new HashMap<>();
        claims.put("id", user.getId());
        claims.put("password", user.getPassword());
        claims.put("sex", user.getSex());

        JwtBuilder jwtBuilder = Jwts.builder()
                .setClaims(claims)
                .setId(UUID.randomUUID().toString().replaceAll("-", ""))
                .setIssuedAt(now)
                .setSubject(user.getId().toString())
                .signWith(hs256, user.getPassword());

        if (ttlMillis > 0) {
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);
            jwtBuilder.setExpiration(exp);
        }
        return jwtBuilder.compact();
    }

    public static Claims parserJWT(String token, User user) {
        Claims claims = Jwts.parser()
                .setSigningKey(user.getPassword())
                .parseClaimsJws(token).getBody();
        return claims;
    }

    public static Boolean isverify(String token, User user) {
        Claims claims = Jwts.parser()
                .setSigningKey(user.getPassword())
                .parseClaimsJws(token).getBody();

        if (claims.get("password").toString().equals(user.getPassword())) {
            return true;
        }
        return false;
    }
}

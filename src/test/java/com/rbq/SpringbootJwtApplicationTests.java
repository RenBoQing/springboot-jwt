package com.rbq;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
import java.util.Date;


class SpringbootJwtApplicationTests {

    @Test
    void contextLoads() {
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.SECOND, 20);
        String token = JWT.create()
                .withClaim("username", "RenBoQing") //指定payload  可以方很多不敏感信息
                .withClaim("userId", 12)
                .withExpiresAt(instance.getTime()) //设置过期
                .sign(Algorithm.HMAC256("tokenDemo15415"));
        System.out.println(token);
    }

    @Test
    void Test() {
        //     验证token
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("tokenDemo15415")).build();
        DecodedJWT verify = jwtVerifier.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2NzU3NTU5NDMsInVzZXJJZCI6MTIsInVzZXJuYW1lIjoiUmVuQm9RaW5nIn0.3HybyeeURAFeC5AMiLUD52pnm6X0Ql886nXcI4Szd7E");
        System.out.println(verify.getClaim("username").asString());
        System.out.println(verify.getClaim("userId").asInt());
        System.out.println(verify.getExpiresAt());
        System.out.println(verify.getSignature().toString());
    }
}

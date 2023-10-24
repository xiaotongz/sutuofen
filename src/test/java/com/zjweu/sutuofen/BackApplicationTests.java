package com.zjweu.sutuofen;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BackApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void test() {
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIyMDIxYjQ2MDAzIiwiZXhwIjoxNjk4MTM2NDQ0fQ.fCOG7KbnLBpAvOuvq2uweGoKg6JTFjjzbs-w9JoVxdg";

        //JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("!Q@W#E$R")).build();
        //DecodedJWT decodedJWT = jwtVerifier.verify(token);
//        System.out.println("用户Id：" + decodedJWT.getClaim("userId").asInt());
//        System.out.println("用户名：" + decodedJWT.getClaim("username").asString());
//        System.out.println("过期时间：" + decodedJWT.getExpiresAt());
        System.out.println(JWT.decode(token).getAudience().get(0));
    }

    @Test
    void test2() {
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2ODQ0MTc5ODUsInVzZXJJZCI6MjEsInVzZXJuYW1lIjoienVoYW8ifQ.ZZUQPBHvNpil2YIV7rQa-6GsCkoLtdXTe6B7gvgR-m8";

        System.out.println(JWT.decode(token).getClaim("username").asString());
    }

    @Test
    void test3() {
        int i = 0/0;

    }
}

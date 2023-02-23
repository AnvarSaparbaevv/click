package com.example.newclick.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtProvider {

    static long exipireTime=36000000;
    static String secretKey="JWT";
    public static String generateToken(String username){
        String  token=Jwts
                .builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+exipireTime))
                .signWith(SignatureAlgorithm.HS256,secretKey)
                .compact();
        return token;
    }

    public static void main(String[] args) {
        String token=generateToken("userToken");
        System.out.println(token);
    }
}

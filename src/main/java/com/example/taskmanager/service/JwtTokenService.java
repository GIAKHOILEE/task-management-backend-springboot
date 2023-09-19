package com.example.taskmanager.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
@Component
public class JwtTokenService {

    @Value("${jwt.secret}")
    private String secret;

    // Thời gian hết hạn của JWT (đây là 5 giờ)
    public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;

    public String generateToken(String email, String firstname, String lastname, String avatar, Long phone) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("email", email);
        claims.put("firstname", firstname);
        claims.put("lastname", lastname);
        claims.put("avatar", avatar);
        claims.put("phone", phone);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }
}

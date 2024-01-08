package com.example.taskmanager.token;
import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;

public class decodeToken {
    public static String decodeTokenAndGetEmail(String token) {
        // Lấy ra DecodedJWT từ token
        DecodedJWT decodedJWT = JWT.decode(token);

        // Lấy email từ claim
        String email = decodedJWT.getClaim("email").asString();

        return email;
    }
}

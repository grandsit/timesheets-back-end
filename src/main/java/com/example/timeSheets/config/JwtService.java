package com.example.timeSheets.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Service;

@Service
public class JwtService {
    public String extractUserName(String jwt) {
        return null;
    }

//    private Claims extractAllClaims(String token){
//        return Jwts
//                .builder()
//                .
//    }
}

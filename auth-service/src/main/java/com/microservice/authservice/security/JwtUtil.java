package com.microservice.authservice.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class JwtUtil implements Serializable {

    private static final long serialVersionUID = 1L;

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.token.validity}")
    private String expirationTime;
//
//    public String generateToken(Authentication authentication, User user) {
//        final String authorities = authentication.getAuthorities().stream()
//                .map(GrantedAuthority::getAuthority)
//                .collect(Collectors.joining(","));
//        return Jwts.builder()
//                .setSubject(authentication.getName())
//                .claim(AUTHORITIES_KEY, authorities)
//                .signWith(SignatureAlgorithm.HS256, SIGNING_KEY)
//                .setIssuedAt(new Date(System.currentTimeMillis()))
//                .setExpiration(new Date(System.currentTimeMillis() + ACCESS_TOKEN_VALIDITY_SECONDS*1000))
//                .claim(USER_IMAGE, user.getImageUrl())
//                .claim(USER_ID, user.getId())
//                .claim(USER_NAME, user.getName())
//                .claim(IS_FIRST_LOGIN, new BCryptPasswordEncoder().matches(user.getEmail(), user.getPassword()))
//                .compact();
//    }
}

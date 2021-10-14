package com.microservice.authservice.security;

import com.microservice.authservice.dtos.LoginDTO;
import com.microservice.authservice.dtos.UserDTO;
import com.microservice.authservice.services.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.impl.DefaultClaims;
import org.springframework.beans.factory.annotation.Autowired;
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

    private Claims claims = new DefaultClaims();

    @Autowired
    private UserService userService;

    public Claims getAllClaimsFromToken(final String token) {
        try {
            claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return claims;
    }

    public String generateToken(LoginDTO loginDTO) {
           UserDTO userDTO = userService.test();
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
        return "ola";
    }
}

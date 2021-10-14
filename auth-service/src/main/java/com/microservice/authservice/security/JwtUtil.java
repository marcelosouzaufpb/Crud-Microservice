package com.microservice.authservice.security;

import com.microservice.authservice.dtos.AuthorityDTO;
import com.microservice.authservice.dtos.LoginDTO;
import com.microservice.authservice.dtos.UserDTO;
import com.microservice.authservice.services.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.DefaultClaims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.stream.Collectors;

import static com.microservice.authservice.security.SecurityConstants.*;

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
        UserDTO userDTO = userService.getUserByEmail(loginDTO.getEmail());
        final String authorities = userDTO.getProfile().getAuthorities().stream()
                .map(AuthorityDTO::getName).collect(Collectors.joining(","));

        return doGenerateToken(userDTO, authorities);
    }

    private String doGenerateToken(UserDTO userDTO, String authorities) {
        long expirationTimeLong = ACCESS_TOKEN_VALIDITY_SECONDS * 1000;
        final Date createdDate = new Date();
        final Date expirationDate = new Date(createdDate.getTime() + expirationTimeLong);

        return Jwts.builder()
                .setSubject(userDTO.getProfile().getName())
                .claim(AUTHORITIES_KEY, authorities)
                .signWith(SignatureAlgorithm.HS512, secret)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(expirationDate)
                .claim(USER_ID, userDTO.getId())
                .claim(USER_NAME, userDTO.getEmail())
                .claim(IS_FIRST_LOGIN, new BCryptPasswordEncoder().matches(userDTO.getEmail(), userDTO.getPassword()))
                .compact();
    }

    public Date getExpirationDateFromToken(String token) {
        return getAllClaimsFromToken(token).getExpiration();
    }

    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    public Boolean validateToken(String token) {
        return !isTokenExpired(token);
    }
}

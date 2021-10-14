package com.microservice.authservice.services;

import com.microservice.authservice.dtos.LoginDTO;
import com.microservice.authservice.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final JwtUtil jwt;

    @Autowired
    public AuthService(final JwtUtil jwt) {
        this.jwt = jwt;
    }

    public String register(LoginDTO loginDTO) {
        String token = this.jwt.generateToken(loginDTO);
//        jwt.getAllClaimsFromToken(token);
        return token;
    }

}

package com.microservice.authservice.controllers;

import com.microservice.authservice.security.JwtUtil;
import com.microservice.authservice.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    @Autowired
    private JwtUtil jwtTokenUtil;

    private final AuthService authService;

    public AuthenticationController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping(value = "/auth/authenticate")
    public ResponseEntity<String> register() {
        return ResponseEntity.ok(authService.register());
    }
}

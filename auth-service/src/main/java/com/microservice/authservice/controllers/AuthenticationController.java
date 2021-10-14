package com.microservice.authservice.controllers;

import com.microservice.authservice.dtos.LoginDTO;
import com.microservice.authservice.security.JwtUtil;
import com.microservice.authservice.services.AuthService;
import com.microservice.authservice.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.microservice.authservice.utils.UrlConstants.*;

@RestController
@RequestMapping(AUTH_URL)
public class AuthenticationController {

    private JwtUtil jwtTokenUtil;

    private final AuthService authService;

    public AuthenticationController(JwtUtil jwtTokenUtil, AuthService authService) {
        this.authService = authService;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @PostMapping(value = AUTHENTICATE_URL)
    public ResponseEntity<String> register(@RequestBody LoginDTO loginDTO) {
        return ResponseEntity.ok(this.authService.register(loginDTO));
    }
}

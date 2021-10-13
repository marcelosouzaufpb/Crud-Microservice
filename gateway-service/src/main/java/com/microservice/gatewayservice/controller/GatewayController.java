package com.microservice.gatewayservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.microservice.gatewayservice.utils.UrlConstants.GATEWAY_URL;

@RestController
@RequestMapping(GATEWAY_URL)
public class GatewayController {

    @GetMapping()
    public ResponseEntity<String> fallback() {
        return ResponseEntity.ok("Gateway On");
    }
}

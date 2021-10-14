package com.microservice.authservice.proxys;

import com.microservice.authservice.dtos.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "user-service", path = "/users")
public interface UserProxy {

    @GetMapping("/teste")
    public ResponseEntity<UserDTO> test();

}

package com.microservice.authservice.proxys;

import com.microservice.authservice.dtos.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import static com.microservice.authservice.utils.UrlConstants.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@FeignClient(name = "user-service", path = USER_URL)
public interface UserProxy {

	@GetMapping(PARAMS_EMAIL)
    public ResponseEntity<UserDTO> findByEmail(@Valid @NotNull @PathVariable String email);

    @GetMapping(PARAMS_ID)
    public ResponseEntity<UserDTO> findById(@Valid @NotNull @PathVariable Long id);

}

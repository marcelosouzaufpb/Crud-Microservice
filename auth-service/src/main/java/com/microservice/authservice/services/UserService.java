package com.microservice.authservice.services;

import com.microservice.authservice.dtos.UserDTO;
import com.microservice.authservice.proxys.UserProxy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {

    private UserProxy userProxy;

    public UserService(UserProxy userProxy) {
        this.userProxy = userProxy;
    }

    public UserDTO test() {
        return this.userProxy.test().getBody();
    }

}

package com.microservice.userservice.utils;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

import static com.microservice.userservice.utils.UrlConstants.PARAMS_ID;

public class ResponseUtils {

    private ResponseUtils() {
    }


    public static URI toURI(Long entityId) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path(PARAMS_ID).buildAndExpand(entityId).toUri();
    }

}

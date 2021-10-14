package com.microservice.authservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    public static final int PASSWORD_MIN_LENGTH = 6;

    private Long id;

    private String email;

    private String password;

    private ProfileDTO profile;
}

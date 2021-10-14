package com.microservice.authservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTO {

    @NotBlank(message = "{general.email.field.notBlank}")
    private String email;

    @NotBlank(message = "{info.login.password.notBlank}")
    private String password;
}

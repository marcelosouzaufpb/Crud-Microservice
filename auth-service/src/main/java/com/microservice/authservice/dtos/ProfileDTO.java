package com.microservice.authservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileDTO {

    private Long id;

    private String name;

    private String description;

    private Set<AuthorityDTO> authorities;
}

package com.microservice.userservice.dtos;

import com.microservice.userservice.domains.Authority;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorityDTO {

    private Long id;

    private String name;

    private String description;

    public AuthorityDTO(Authority authority) {
        this.id = authority.getId();
        this.name = authority.getName();
        this.description = authority.getDescription();
    }
}

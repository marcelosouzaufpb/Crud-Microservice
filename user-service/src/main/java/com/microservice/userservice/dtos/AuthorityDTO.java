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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

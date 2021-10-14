package com.microservice.userservice.dtos;

import com.microservice.userservice.domains.Profile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;
import java.util.stream.Collectors;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileDTO {

    private Long id;

    @NotBlank(message = "{general.name.field.notBlank}")
    private String name;

    @Size(max = 2000, message = "{info.profile.description.size}")
    private String description;

    @NotEmpty(message = "{info.profile.authorityIdList.notEmpty}")
    private Set<AuthorityDTO> authorities;

    public ProfileDTO(Profile profile) {
        this.id = profile.getId();
        this.name = profile.getName();
        this.description = profile.getDescription();
        this.authorities = profile.getAuthorities().stream().map(AuthorityDTO::new).collect(Collectors.toSet());
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

    public Set<AuthorityDTO> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<AuthorityDTO> authorities) {
        this.authorities = authorities;
    }
}

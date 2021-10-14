package com.microservice.userservice.domains;


import com.microservice.userservice.dtos.ProfileDTO;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Table(name = "profiles")
public class Profile implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30, nullable = false)
    private String name;

    @Column(length = 2000)
    private String description;

    @OrderBy("name ASC")
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "profile_authority",
            joinColumns = {@JoinColumn(name = "profile_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "authority_id", referencedColumnName = "id")})
    private Set<Authority> authorities = new HashSet<>();

    @Column(nullable = false)
    private boolean activated = true;

    public Profile(ProfileDTO profileDTO) {
        this.id = profileDTO.getId();
        this.name = profileDTO.getName();
        this.description = profileDTO.getDescription();
        this.authorities = profileDTO.getAuthorities().stream().map(Authority::new).collect(Collectors.toSet());
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

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }
}

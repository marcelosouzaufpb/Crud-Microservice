package com.microservice.userservice.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.microservice.userservice.dtos.UserDTO;
import lombok.*;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Table(name = "users")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 256, unique = true, nullable = false)
    private String email;

    @JsonIgnore
    @Column(length = 60, nullable = false)
    private String password;

    @ManyToOne
    private Profile profile;

    public User(UserDTO userDTO) {
        BeanUtils.copyProperties(userDTO, this);
        if (Objects.nonNull(userDTO.getProfile())) this.profile = new Profile(userDTO.getProfile());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}

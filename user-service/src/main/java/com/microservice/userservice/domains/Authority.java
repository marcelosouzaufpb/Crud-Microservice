package com.microservice.userservice.domains;

import com.microservice.userservice.dtos.AuthorityDTO;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Table(name = "authorities")
public class Authority implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String name;

    @Column(length = 200)
    private String description;

    public Authority(AuthorityDTO authorityDTO) {
        this.id = authorityDTO.getId();
        this.name = authorityDTO.getName();
        this.description = authorityDTO.getDescription();
    }
}

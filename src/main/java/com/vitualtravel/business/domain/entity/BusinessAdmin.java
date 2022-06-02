package com.vitualtravel.business.domain.entity;

import com.vitualtravel.business.infrastructure.controllers.dto.input.BusinessAdminInputDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Users")
@Getter
@Setter
@NoArgsConstructor
public class BusinessAdmin implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    Integer id;

    @Column(name = "user")
    String user;

    @Column(name = "pasword")
    String password;

    @Column(name = "telephone")
    String tel;

    @Column(name = "email")
    String email;

    public BusinessAdmin(BusinessAdminInputDTO inputDTO) {

        setUser(inputDTO.user());
        setPassword(inputDTO.password());
        setTel(inputDTO.tel());
        setEmail(inputDTO.email());
    }

}

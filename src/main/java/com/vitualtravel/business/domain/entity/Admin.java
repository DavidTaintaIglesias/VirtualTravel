package com.vitualtravel.business.domain.entity;

import com.vitualtravel.business.infrastructure.controllers.dto.input.AdminInputDTO;
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
public class Admin implements Serializable {

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

    public Admin(AdminInputDTO inputDTO) {

        setUser(inputDTO.getUser());
        setPassword(inputDTO.getPassword());
        setTel(inputDTO.getTel());
        setEmail(inputDTO.getEmail());
    }

}

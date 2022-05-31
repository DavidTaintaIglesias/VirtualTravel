package com.vitualtravel.business.infrastructure.controllers.dto.output;


import com.vitualtravel.business.domain.entity.Admin;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class AdminOutputDTO {

    private int id;
    private String user;
    private String tel;
    private String email;

    public AdminOutputDTO(Admin admin) {

        setId(admin.getId());
        setUser(admin.getUser());
        setTel(admin.getTel());
        setEmail(admin.getEmail());
    }
}

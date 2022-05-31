package com.vitualtravel.business.application;

import com.vitualtravel.business.domain.entity.Admin;
import com.vitualtravel.business.infrastructure.controllers.dto.input.AdminInputDTO;
import com.vitualtravel.business.infrastructure.controllers.dto.output.AdminOutputDTO;
import com.vitualtravel.business.infrastructure.repository.BusinessAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterAdminService {

    @Autowired
    BusinessAdminRepository repository;

    public AdminOutputDTO registerAdmin(AdminInputDTO adminInput) {

        Admin admin = new Admin(adminInput);
        repository.save(admin);
        return new AdminOutputDTO(admin);
    }
}

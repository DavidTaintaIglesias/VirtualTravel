package com.vitualtravel.business.application.service;

import com.vitualtravel.business.domain.entity.BusinessAdmin;
import com.vitualtravel.business.infrastructure.controllers.dto.input.BusinessAdminInputDTO;
import com.vitualtravel.business.infrastructure.controllers.dto.output.BusinessAdminOutputDTO;
import com.vitualtravel.business.infrastructure.repository.BusinessAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessRegisterAdminService {

    @Autowired
    BusinessAdminRepository repository;

    public BusinessAdminOutputDTO registerAdmin(BusinessAdminInputDTO adminInput) {

        BusinessAdmin admin = new BusinessAdmin(adminInput);
        repository.save(admin);
        return new BusinessAdminOutputDTO(admin);
    }
}

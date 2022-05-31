package com.vitualtravel.business.application;

import com.vitualtravel.business.domain.entity.BusinessReserve;
import com.vitualtravel.business.infrastructure.controllers.dto.input.BusinessReserveInputDTO;
import com.vitualtravel.business.infrastructure.controllers.dto.output.BusinessReserveOutputDTO;
import com.vitualtravel.business.infrastructure.repository.BusinessReserveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessCreateReserveService {

    @Autowired
    BusinessReserveRepository repository;

    public BusinessReserveOutputDTO createReserve(BusinessReserveInputDTO businessReserveInputDTO) {

        BusinessReserve businessReserve = new BusinessReserve(businessReserveInputDTO);
        repository.save(businessReserve);
        return new BusinessReserveOutputDTO(businessReserve);
    }
}

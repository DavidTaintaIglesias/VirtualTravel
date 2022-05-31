package com.vitualtravel.business.application.service;

import com.vitualtravel.business.domain.entity.BusinessReserve;
import com.vitualtravel.business.infrastructure.repository.BusinessReserveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessGetReservesService {

    @Autowired
    BusinessReserveRepository repository;

    public List<BusinessReserve> getReserves() {

        return repository.findAll();
    }
}

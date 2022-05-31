package com.vitualtravel.web.application.services;

import com.vitualtravel.shared.exceptions.Unprocessable;
import com.vitualtravel.web.domain.entity.WebReserve;
import com.vitualtravel.web.infrastructure.controller.dto.input.WebReserveInputDTO;
import com.vitualtravel.web.infrastructure.repository.WebReserveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class WebCreateReserveService {

    @Autowired
    WebReserveRepository repository;

    @Value("${maxPersonOnBus}")
    int numberSits;

    //Terminar el metodo, añade pero devuelve un 406 de error
    public void createReserve(WebReserveInputDTO reserveInput){

        //Rest template a la base de datos de business
    }
}

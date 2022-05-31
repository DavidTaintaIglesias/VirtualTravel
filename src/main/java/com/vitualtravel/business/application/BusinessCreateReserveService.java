package com.vitualtravel.business.application;

import com.vitualtravel.business.domain.entity.BusinessReserve;
import com.vitualtravel.business.infrastructure.controllers.dto.input.BusinessReserveInputDTO;
import com.vitualtravel.business.infrastructure.controllers.dto.output.BusinessReserveOutputDTO;
import com.vitualtravel.business.infrastructure.repository.BusinessReserveRepository;
import com.vitualtravel.shared.exceptions.Unprocessable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class BusinessCreateReserveService {

    @Autowired
    BusinessReserveRepository repository;

    @Value("${maxPersonOnBus}")
    int numberSits;

    public BusinessReserve createReserve(BusinessReserveInputDTO businessReserveInputDTO) {

        //Añadir limitacion de asientos por trayecto
        BusinessReserve businessReserve = new BusinessReserve(businessReserveInputDTO);

        if(repository.findByArrivalAndTravelHour(businessReserve.getArrival(), businessReserve.getTravelHour()).stream().count()==numberSits){
            throw new Unprocessable("Sorry, bus completed");
        }

        repository.save(businessReserve);
        return businessReserve;
    }
}

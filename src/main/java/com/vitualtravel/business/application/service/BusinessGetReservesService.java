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

    public List<BusinessReserve> getAllReserves() {

        return repository.findAll();
    }

    public List<BusinessReserve> getReservesByTrip(String arrival, String travelHour) {

        return repository.findByArrivalAndTravelHour(arrival, travelHour);
    }

    public List<BusinessReserve> getReservesByArrival(String arrival) {

        return repository.findByArrival(arrival);
    }

    public List<BusinessReserve> getReservesByTravelHour(String travelHour) {

        return repository.findByTravelHour(travelHour);
    }
}

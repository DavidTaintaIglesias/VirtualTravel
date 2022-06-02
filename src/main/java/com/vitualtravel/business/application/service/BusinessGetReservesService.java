package com.vitualtravel.business.application.service;

import com.vitualtravel.business.domain.entity.BusinessDepartureHoursEnum;
import com.vitualtravel.business.domain.entity.BusinessReserve;
import com.vitualtravel.business.infrastructure.repository.BusinessReserveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

    public List<BusinessReserve> getFilteredReserves(String minDate, String maxDate, String hourMin, String hourMax) {

        LocalDate dateMin;
        LocalDate dateMax;

        if(hourMin==null) {
            hourMin = BusinessDepartureHoursEnum.FIRST.getHours();
        }

        if(hourMax==null) {
            hourMax = BusinessDepartureHoursEnum.LAST.getHours();
        }

        if(minDate==null) {
            dateMin = LocalDate.now();
        } else {
            dateMin = LocalDate.parse(minDate);
        }

        if(maxDate==null){
            dateMax = LocalDate.now().plusWeeks(1);
        } else {
            dateMax = LocalDate.parse(maxDate);
        }

        return repository.findByDateBetweenAndTravelHourBetween(dateMin, dateMax, hourMin, hourMax);
    }
}

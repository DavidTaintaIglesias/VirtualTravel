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

    public List<BusinessReserve> getReservesByTrip(String departure, String arrival, String travelHour) {

        if(arrival==null && travelHour== null) {
            return repository.findByDeparture(departure);
        }

        if(arrival==null){
            return repository.findByDepartureAndTravelHour(departure, travelHour);
        }

        if(travelHour==null){
            return repository.findByDepartureAndArrival(departure, arrival);
        }

        return repository.findByDepartureAndArrivalAndTravelHour(departure, arrival, travelHour);
    }

    public List<BusinessReserve> getFilteredReserves(String departure, String arrival, String minDate, String maxDate, String hourMin, String hourMax) {

        LocalDate dateMin;
        LocalDate dateMax;

        hourMin = hourMin == null ? BusinessDepartureHoursEnum.FIRST.getHours() : hourMin;

        hourMax = hourMax == null ? BusinessDepartureHoursEnum.LAST.getHours() : hourMax;

        dateMin = minDate == null ? LocalDate.now() : LocalDate.parse(minDate);

        dateMax = maxDate == null ? LocalDate.now().plusWeeks(1) : LocalDate.parse(maxDate);

        return repository.findByDepartureAndArrivalAndDateBetweenAndTravelHourBetween(departure, arrival, dateMin, dateMax, hourMin, hourMax);
    }
}

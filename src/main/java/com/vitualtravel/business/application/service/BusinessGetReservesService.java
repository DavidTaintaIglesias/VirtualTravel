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

    public List<BusinessReserve> getFilteredReserves(String arrival, String minDate, String maxDate, String hourMin, String hourMax) {

        LocalDate dateMin;
        LocalDate dateMax;

        hourMin = hourMin == null ? BusinessDepartureHoursEnum.FIRST.getHours() : hourMin;

        hourMax = hourMax == null ? BusinessDepartureHoursEnum.LAST.getHours() : hourMax;

        dateMin = minDate == null ? LocalDate.now() : LocalDate.parse(minDate);

        dateMax = maxDate == null ? LocalDate.now().plusWeeks(1) : LocalDate.parse(maxDate);

        return repository.findByArrivalAndDateBetweenAndTravelHourBetween(arrival, dateMin, dateMax, hourMin, hourMax);
    }
}

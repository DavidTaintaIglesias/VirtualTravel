package com.vitualtravel.business.infrastructure.repository;

import com.vitualtravel.business.domain.entity.BusinessReserve;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface BusinessReserveRepository extends JpaRepository<BusinessReserve, Integer> {

    List<BusinessReserve> findByDepartureAndArrivalAndDateBetweenAndTravelHourBetween(String departure, String arrival, LocalDate dateMin, LocalDate dateMax, String hourMin, String hourMax);
    List<BusinessReserve> findByDepartureAndArrivalAndTravelHour(String departure, String arrival, String travelHour);

}

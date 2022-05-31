package com.vitualtravel.web.infrastructure.repository;

import com.vitualtravel.web.domain.entity.WebReserve;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WebReserveRepository extends JpaRepository<WebReserve, Integer> {

    List<WebReserve> findByArrivalAndTravelHour(String arrival, String travelHour);

}

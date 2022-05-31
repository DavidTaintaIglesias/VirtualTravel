package com.vitualtravel.business.infrastructure.repository;

import com.vitualtravel.business.domain.entity.BusinessReserve;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BusinessReserveRepository extends JpaRepository<BusinessReserve, Integer> {

    List<BusinessReserve> findByArrivalAndTravelHour(String arrival, String travelHour);
}

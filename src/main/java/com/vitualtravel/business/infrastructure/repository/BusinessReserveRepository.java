package com.vitualtravel.business.infrastructure.repository;

import com.vitualtravel.business.domain.entity.BusinessReserve;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessReserveRepository extends JpaRepository<BusinessReserve, Integer> {
}

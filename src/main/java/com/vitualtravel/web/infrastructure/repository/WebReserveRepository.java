package com.vitualtravel.web.infrastructure.repository;

import com.vitualtravel.web.domain.entity.WebReserve;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WebReserveRepository extends JpaRepository<WebReserve, Integer> {
}

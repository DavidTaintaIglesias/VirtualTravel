package com.vitualtravel.business.infrastructure.repository;

import com.vitualtravel.business.domain.entity.BusinessAdmin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BusinessAdminRepository extends JpaRepository<BusinessAdmin, Integer> {

    Optional<BusinessAdmin> findByUser(String user);
}

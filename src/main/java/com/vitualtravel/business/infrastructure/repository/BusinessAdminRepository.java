package com.vitualtravel.business.infrastructure.repository;

import com.vitualtravel.business.domain.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessAdminRepository extends JpaRepository<Admin, Integer> {
}

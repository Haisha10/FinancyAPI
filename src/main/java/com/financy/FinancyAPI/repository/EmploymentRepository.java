package com.financy.FinancyAPI.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.financy.FinancyAPI.model.entity.Employment;

public interface EmploymentRepository extends JpaRepository<Employment, Long> {
    List<Employment> findByUserId(Long userId);
    Optional<Employment> findById(Long id);
}

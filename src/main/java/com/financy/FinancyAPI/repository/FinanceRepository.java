package com.financy.FinancyAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.financy.FinancyAPI.model.entity.Finance;

public interface FinanceRepository extends JpaRepository<Finance, Long> {
    List<Finance> findByUserId(Long id);
}

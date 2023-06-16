package com.financy.FinancyAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.financy.FinancyAPI.model.entity.Finances;

public interface FinancesRepository extends JpaRepository<Finances, Long> {
    
}

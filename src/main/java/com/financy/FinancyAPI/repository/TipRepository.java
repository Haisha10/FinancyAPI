package com.financy.FinancyAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.financy.FinancyAPI.model.entity.Tips;



public interface TipRepository extends JpaRepository<Tips, Long> {
    
}

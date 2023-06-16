package com.financy.FinancyAPI.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.financy.FinancyAPI.model.entity.Employments;


public interface EmploymentsRepository extends JpaRepository<Employments, Long> {
    
}
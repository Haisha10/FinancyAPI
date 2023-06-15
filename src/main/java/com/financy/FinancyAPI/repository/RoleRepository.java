package com.financy.FinancyAPI.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.financy.FinancyAPI.model.entity.Role;
import com.financy.FinancyAPI.util.UserRoleName;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(UserRoleName name);
}

package com.financy.FinancyAPI.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.financy.FinancyAPI.model.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    //Query of the method findByEmailAndPassword
    @Query(value = "SELECT * FROM user_role ur JOIN users u ON u.id = ur.user_id JOIN roles r ON r.id = ur.role_id WHERE u.email = :email and u.password = :password;", nativeQuery = true)
    Optional<User> findByEmailAndPassword(String email, String password);
    List<User> findByEmail(String email);
}

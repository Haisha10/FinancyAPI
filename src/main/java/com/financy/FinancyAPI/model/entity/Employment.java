package com.financy.FinancyAPI.model.entity;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employments")
public class Employment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long ruc;
    String name;
    String description;
    Date creationDate;
    String address;
    Long phone;
    String email;
    String requirements;
    Double salary;
    Boolean isAvailable;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "employment_user", joinColumns = @JoinColumn(name = "employment_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"))
    private List<User> postulants;
}

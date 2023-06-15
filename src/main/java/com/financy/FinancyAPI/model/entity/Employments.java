package com.financy.FinancyAPI.model.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employments")
public class Employments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long ruc;
    private String name;
    private String description;
    private Date creationDate;
    private String address;
    private Long phone;
    private String email;
    private String requirements;
    private Double salary;
    private Boolean isAvailable;
    @ManyToOne
    @JoinColumn(name = "userId")
    private User[] postulants;
}

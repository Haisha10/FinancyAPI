package com.financy.FinancyAPI.model.entity;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
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
@Table(name = "finances")
public class Finances {
    private Long id;
    private Long finances_type_id;
    private Long user_id;
    private Timestamp timestamp;
    private String name;
    private Double exchange;
    private String comment;
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
    
}

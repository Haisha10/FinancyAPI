package com.financy.FinancyAPI.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tips")
public class Tips {
    private Long id;
    private String title;
    private String description;
    private String image;
}

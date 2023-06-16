package com.financy.FinancyAPI.model.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FinancesDTO implements Serializable {
    private Long id;
    private Boolean isIncome;
    private Timestamp timestamp;
    private String name;
    private Double exchange;
    private String comment;
}

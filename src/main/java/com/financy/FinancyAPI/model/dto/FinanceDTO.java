package com.financy.FinancyAPI.model.dto;

import java.io.Serializable;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FinanceDTO implements Serializable {
    private Long id;
    private String name;
    private Date date;
    private Double exchange;
    private String comment;
    private Boolean isIncome;
}

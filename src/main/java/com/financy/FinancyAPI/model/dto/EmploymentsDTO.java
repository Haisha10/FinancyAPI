package com.financy.FinancyAPI.model.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmploymentsDTO implements Serializable {
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
    private Integer quantityUser;
}

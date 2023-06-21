package com.financy.FinancyAPI.model.dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmploymentDTO implements Serializable {
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
    List<Long> postulants;
}

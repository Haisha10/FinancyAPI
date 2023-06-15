package com.financy.FinancyAPI.model.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO implements Serializable {
    private Long id;
    private String email;
    private String password;
    private String name;
    private String lastname;
    private Boolean isBusiness;

    public void setIsBusiness(Boolean isBusiness) {
        // Perform any additional logic or validation if needed
        if(isBusiness == null) isBusiness = false;
        this.isBusiness = isBusiness;
    }
}

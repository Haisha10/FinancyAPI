package com.financy.FinancyAPI.controller;

import com.financy.FinancyAPI.model.dto.EmploymentsDTO;
import com.financy.FinancyAPI.model.dto.FinancesDTO;
import com.financy.FinancyAPI.model.dto.UserDTO;
import com.financy.FinancyAPI.model.entity.Employments;
import com.financy.FinancyAPI.model.entity.Finances;
import com.financy.FinancyAPI.model.entity.User;
import com.financy.FinancyAPI.model.entity.Role;
import com.financy.FinancyAPI.service.EmploymentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prueba")
public class EmploymentsController {
/*    
    @Autowired
    private EmploymentsService employmentService;

     //leer
    
    @GetMapping("/employments")
    public ResponseEntity<List<EmploymentsDTO>> findAll() {
        return new  ResponseEntity<List<EmploymentsDTO>>(employmentService.findAll(), HttpStatus.OK);
    }
    

    //insertar 
    @PostMapping("/employments")
    public ResponseEntity<Employments> createEmployments (@RequestBody EmploymentsDTO employmentsId) {
        return new ResponseEntity<Employments>(employmentService.createEmployments(employmentsId), HttpStatus.CREATED);
    }

    //actualizar
    @PutMapping("/employments/{id}")
    public ResponseEntity<Employments> updateEmployments (@PathVariable (value = "id") Long employmentsId, @RequestBody EmploymentsDTO employments) {
        return new ResponseEntity<Employments>(employmentService.updateEmployments(employmentsId, employments), HttpStatus.OK);
    }
    
    //eliminar
    @DeleteMapping("/employments/{id}")
    public ResponseEntity<Employments> deleteEmployments (@PathVariable (value = "id") Long employmentsId) {
        return new ResponseEntity<Employments>(employmentService.deleteEmployments(employmentsId), HttpStatus.NO_CONTENT);
    }

    // usuario inscrito
    @PutMapping("/employments/{id}")
    public ResponseEntity<Employments> AddUser (@PathVariable (value = "userid") Long userId, @PathVariable (value = "id") Long employmentsId) {
        return new ResponseEntity<Employments>(employmentService.AddUser(userId, employmentsId), HttpStatus.CREATED);
    }
*/
}

package com.financy.FinancyAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.financy.FinancyAPI.model.dto.FinanceDTO;
import com.financy.FinancyAPI.service.FinanceService;

@CrossOrigin(origins = { "https://haisha10.github.io" })
@RestController
@RequestMapping("/api/v1")
public class FinanceController {
    @Autowired
    private FinanceService financeService;

    @GetMapping("/finances")
    public ResponseEntity<List<FinanceDTO>> getAllFinancesDTO(@Param("userId") Long userId) {
        return new ResponseEntity<List<FinanceDTO>>(financeService.getAllFinances(userId), HttpStatus.OK);
    }

    @PostMapping("/finances")
    public ResponseEntity<FinanceDTO> createFinanceDTO(@RequestBody FinanceDTO financeDTO, @Param("userId") Long userId) {
        return new ResponseEntity<FinanceDTO>(financeService.createFinance(financeDTO, userId), HttpStatus.CREATED);
    }

    @PutMapping("/finances")
    public ResponseEntity<FinanceDTO> updateFinanceDTO(@Param("financeId") Long financeId, @RequestBody FinanceDTO financeDTO, @Param("userId") Long userId) {
        return new ResponseEntity<FinanceDTO>(financeService.updateFinance(financeId, financeDTO, userId), HttpStatus.OK);
    }

    @DeleteMapping("/finances")
    public ResponseEntity<FinanceDTO> deleteFinanceDTO(@Param("financeId") Long financeId) {
        return new ResponseEntity<FinanceDTO>(financeService.deleteFinance(financeId), HttpStatus.NO_CONTENT);
    }
    
    
}

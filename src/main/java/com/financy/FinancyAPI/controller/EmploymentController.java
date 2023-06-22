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
import com.financy.FinancyAPI.model.dto.EmploymentDTO;

import com.financy.FinancyAPI.service.EmploymentService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api/v1")
public class EmploymentController {
        @Autowired
        private EmploymentService employmentService;

        @GetMapping("/employments")
        public ResponseEntity<List<EmploymentDTO>> getAllEmploymentsDTO() {
                return new ResponseEntity<List<EmploymentDTO>>(
                                employmentService.getAllEmployments(), HttpStatus.OK);
        }

        @GetMapping("/employments/{userId}")
        public ResponseEntity<List<EmploymentDTO>> getAllEmploymentsDTOByUserId(
                        @Param("userId") Long userId) {
                return new ResponseEntity<List<EmploymentDTO>>(
                                employmentService.getAllEmploymentsByUserId(userId), HttpStatus.OK);
        }

        @PostMapping("/employments")
        public ResponseEntity<EmploymentDTO> createEmploymentDTO(
                        @RequestBody EmploymentDTO employmentDTO, @Param("userId") Long userId) {
                return new ResponseEntity<EmploymentDTO>(
                                employmentService.createEmployment(employmentDTO, userId), HttpStatus.CREATED);
        }

        @PutMapping("/employments")
        public ResponseEntity<EmploymentDTO> updateEmploymentDTO(
                        @Param("employmentId") Long employmentId,
                        @RequestBody EmploymentDTO employmentDTO, @Param("userId") Long userId) {
                return new ResponseEntity<EmploymentDTO>(
                                employmentService.updateEmployment(employmentId, employmentDTO, userId), HttpStatus.OK);
        }

        @DeleteMapping("/employments")
        public ResponseEntity<EmploymentDTO> deleteEmploymentDTO(
                        @Param("employmentId") Long employmentId) {
                return new ResponseEntity<EmploymentDTO>(
                                employmentService.deleteEmployment(employmentId), HttpStatus.NO_CONTENT);
        }
}

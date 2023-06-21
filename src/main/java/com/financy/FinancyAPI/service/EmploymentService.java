package com.financy.FinancyAPI.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.financy.FinancyAPI.model.dto.EmploymentDTO;
import com.financy.FinancyAPI.model.entity.Employment;
import com.financy.FinancyAPI.model.entity.User;
import com.financy.FinancyAPI.repository.EmploymentRepository;
import com.financy.FinancyAPI.repository.UserRepository;

@Service
public class EmploymentService {
    @Autowired
    EmploymentRepository employmentRepository;

    @Autowired
    UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<EmploymentDTO> getAllEmployments() {
        List<EmploymentDTO> employmentDTOs = new ArrayList<EmploymentDTO>();
        List<Employment> employments = employmentRepository.findAll();
        for (Employment employment : employments) {
            List<Long> postulants = new ArrayList<Long>();
            for (User postulant : employment.getPostulants()) {
                postulants.add(postulant.getId());
            }
            employmentDTOs.add(new EmploymentDTO(employment.getId(), employment.getRuc(), employment.getName(),
                    employment.getDescription(), employment.getCreationDate(), employment.getAddress(),
                    employment.getPhone(), employment.getEmail(), employment.getRequirements(), employment.getSalary(),
                    employment.getIsAvailable(), postulants));
        }
        return employmentDTOs;
    }

    @Transactional(readOnly = true)
    public List<EmploymentDTO> getAllEmploymentsByUserId(Long userId) {
        List<EmploymentDTO> employmentDTOs = new ArrayList<EmploymentDTO>();
        List<Employment> employments = employmentRepository.findByUserId(userId);
        for (Employment employment : employments) {
            List<Long> postulants = new ArrayList<Long>();
            for (User postulant : employment.getPostulants()) {
                postulants.add(postulant.getId());
            }
            employmentDTOs.add(new EmploymentDTO(employment.getId(), employment.getRuc(), employment.getName(),
                    employment.getDescription(), employment.getCreationDate(), employment.getAddress(),
                    employment.getPhone(), employment.getEmail(), employment.getRequirements(), employment.getSalary(),
                    employment.getIsAvailable(), postulants));
        }
        return employmentDTOs;
    }

    @Transactional
    public EmploymentDTO createEmployment(EmploymentDTO employmentDTO, Long userId) {
        Employment employment = new Employment(0l, employmentDTO.getRuc(), employmentDTO.getName(),
                employmentDTO.getDescription(), employmentDTO.getCreationDate(), employmentDTO.getAddress(),
                employmentDTO.getPhone(), employmentDTO.getEmail(), employmentDTO.getRequirements(),
                employmentDTO.getSalary(), true, userRepository.findById(userId).orElse(null),
                new ArrayList<User>());
        employmentRepository.save(employment);
        return new EmploymentDTO(employment.getId(), employment.getRuc(), employment.getName(),
                employment.getDescription(), employment.getCreationDate(), employment.getAddress(),
                employment.getPhone(), employment.getEmail(), employment.getRequirements(), employment.getSalary(),
                true, new ArrayList<Long>());
    }

    @Transactional
    public EmploymentDTO updateEmployment(Long id, EmploymentDTO employmentDTO, Long userId) {
        Employment employment = employmentRepository.findById(id).orElse(null);
        if (employment == null) {
            return null;
        }
        employment.setRuc(employmentDTO.getRuc());
        employment.setName(employmentDTO.getName());
        employment.setDescription(employmentDTO.getDescription());
        employment.setCreationDate(employmentDTO.getCreationDate());
        employment.setAddress(employmentDTO.getAddress());
        employment.setPhone(employmentDTO.getPhone());
        employment.setEmail(employmentDTO.getEmail());
        employment.setRequirements(employmentDTO.getRequirements());
        employment.setSalary(employmentDTO.getSalary());
        employment.setIsAvailable(employmentDTO.getIsAvailable());

        if (employmentDTO.getPostulants().size() > 0) {
            User postulant = userRepository.findById(employmentDTO.getPostulants().get(0)).orElse(null);
            if (postulant != null) {
                employment.getPostulants().add(postulant);
            }
        }
        employmentRepository.save(employment);
        List<Long> postulants = new ArrayList<Long>();
        for (User postulant : employment.getPostulants()) {
            postulants.add(postulant.getId());
        }
        return new EmploymentDTO(employment.getId(), employment.getRuc(), employment.getName(),
                employment.getDescription(), employment.getCreationDate(), employment.getAddress(),
                employment.getPhone(), employment.getEmail(), employment.getRequirements(), employment.getSalary(),
                employment.getIsAvailable(), postulants);
    }

    @Transactional
    public EmploymentDTO deleteEmployment(Long id) {
        Employment employment = employmentRepository.findById(id).orElse(null);
        if (employment == null) {
            return null;
        }
        employmentRepository.delete(employment);
        List<Long> postulants = new ArrayList<Long>();
        for (User postulant : employment.getPostulants()) {
            postulants.add(postulant.getId());
        }
        return new EmploymentDTO(employment.getId(), employment.getRuc(), employment.getName(),
                employment.getDescription(), employment.getCreationDate(), employment.getAddress(),
                employment.getPhone(), employment.getEmail(), employment.getRequirements(), employment.getSalary(),
                employment.getIsAvailable(), postulants);
    }
}

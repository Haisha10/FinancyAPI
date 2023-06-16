package com.financy.FinancyAPI.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.ArrayList;


import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.financy.FinancyAPI.model.dto.EmploymentsDTO;
import com.financy.FinancyAPI.model.entity.Employments;
import com.financy.FinancyAPI.model.entity.User;
import com.financy.FinancyAPI.repository.EmploymentsRepository;
import com.financy.FinancyAPI.repository.UserRepository;


@Service
public class EmploymentsService {
    @Autowired
    EmploymentsRepository employmentsRepository;
    @Autowired
    UserRepository userRepository;

//leer
    @Transactional(readOnly = true)
    public List<EmploymentsDTO> findAll() {
        List<EmploymentsDTO> employmentsDTO = new ArrayList<EmploymentsDTO>();
        List<Employments> employments = employmentsRepository.findAll();
        for (Employments employment : employments) {
            employmentsDTO.add(new EmploymentsDTO(employment.getId(), employment.getRuc(), employment.getName(), employment.getDescription(),
                    employment.getCreationDate(), employment.getAddress(), employment.getPhone(), employment.getEmail(), employment.getRequirements(), employment.getSalary(),
                    employment.getIsAvailable(),employment.getPostulants().size()));
        }
        return employmentsDTO;
    }

    //CREAR
    @Transactional
    public Employments createEmployments(EmploymentsDTO employmentsDTO){
        Employments employments = new Employments();

        employments.setRuc(employmentsDTO.getRuc());
        employments.setName(employmentsDTO.getName());
        employments.setDescription(employmentsDTO.getDescription());
        employments.setCreationDate(new Date());
        employments.setAddress(employmentsDTO.getAddress());
        employments.setPhone(employmentsDTO.getPhone());
        employments.setEmail(employmentsDTO.getEmail());
        employments.setRequirements(employmentsDTO.getRequirements());
        employments.setSalary(employmentsDTO.getSalary());
        employments.setIsAvailable(employmentsDTO.getIsAvailable());
        employments.setPostulants(new ArrayList<User>());

        return employmentsRepository.save(employments);
    }

    //ACTUALIZAR
    @Transactional
    public Employments updateEmployments(Long employmentsID, EmploymentsDTO employmentsDTO){
        Employments employments = employmentsRepository.findById(employmentsID)
        .orElseThrow(()-> new OpenApiResourceNotFoundException("No existe registro con ID = "+ employmentsID));
        if(employments.getRuc().equals(employmentsDTO.getRuc()) && employments.getName().equals(employmentsDTO.getName()) &&
        employments.getDescription().equals(employmentsDTO.getDescription()) && employments.getAddress().equals(employmentsDTO.getAddress()) &&
        employments.getPhone().equals(employmentsDTO.getPhone()) && employments.getEmail().equals(employmentsDTO.getEmail()) &&
        employments.getRequirements().equals(employmentsDTO.getRequirements()) && employments.getSalary().equals(employmentsDTO.getSalary()) &&
        employments.getIsAvailable().equals(employmentsDTO.getIsAvailable())){
            return employments;
        }
        employments.setRuc(employmentsDTO.getRuc());
        employments.setName(employmentsDTO.getName());
        employments.setDescription(employmentsDTO.getDescription());
        employments.setAddress(employmentsDTO.getAddress());
        employments.setPhone(employmentsDTO.getPhone());
        employments.setEmail(employmentsDTO.getEmail());
        employments.setRequirements(employmentsDTO.getRequirements());
        employments.setSalary(employmentsDTO.getSalary());
        employments.setIsAvailable(employmentsDTO.getIsAvailable());
        
        return employmentsRepository.save(employments);
    }

    //ELIMINAR

    @Transactional
    public Employments deleteEmployments (Long employmentsId) {
        Employments  empl = employmentsRepository.findById(employmentsId)
                .orElseThrow(()-> new OpenApiResourceNotFoundException("No existe registro con ID = "+ employmentsId));
        employmentsRepository.deleteById(employmentsId);
        return empl;
    }

    //INSCRIPCIÓN DE USUARIO
    @Transactional
    public Employments AddUser(Long userId,Long employmentsID){
        Employments employments = employmentsRepository.findById(employmentsID)
        .orElseThrow(()-> new OpenApiResourceNotFoundException("No existe registro con ID = "+ employmentsID));
        User user = userRepository.findById(userId)
        .orElseThrow(()-> new OpenApiResourceNotFoundException("No existe registro con ID = "+ userId));
        List<User> users= employments.getPostulants();
        users.add(user);
        employments.setPostulants(users);
        return employments;
    }
}
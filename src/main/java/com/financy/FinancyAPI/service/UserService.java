package com.financy.FinancyAPI.service;

import java.util.ArrayList;
import java.util.List;

import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.financy.FinancyAPI.model.dto.UserDTO;
import com.financy.FinancyAPI.model.entity.Role;
import com.financy.FinancyAPI.model.entity.User;
import com.financy.FinancyAPI.repository.UserRepository;
import com.financy.FinancyAPI.util.UserRoleName;
import com.financy.FinancyAPI.repository.RoleRepository;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Transactional(readOnly = true)
    public List<UserDTO> findAll() {
        List<UserDTO> usersDTO = new ArrayList<UserDTO>();
        List<User> users = userRepository.findAll();
        for (User user : users) {
            Boolean isBusiness = false;
            for (Role role : user.getRoles()) {
                if (role.getName().equals(UserRoleName.ROLE_BUSINESS)) {
                    isBusiness = true;
                    break;
                }
            }
            usersDTO.add(new UserDTO(user.getId(), user.getEmail(), user.getPassword(), user.getName(),
                    user.getLastname(), isBusiness));
        }
        return usersDTO;
    }

    @Transactional(readOnly = true)
    public List<UserDTO> findByEmailAndPassword(String email, String password) {
        User user = userRepository.findByEmailAndPassword(email, password)
                .orElse(null);
        if (user == null) {
            return new ArrayList<UserDTO>();
        }
        Boolean isBusiness = false;
        for (Role role : user.getRoles()) {
            if (role.getName().equals(UserRoleName.ROLE_BUSINESS)) {
                isBusiness = true;
                break;
            }
        }
        List<UserDTO> usersDTO = new ArrayList<UserDTO>();
        usersDTO.add(new UserDTO(user.getId(), user.getEmail(), user.getPassword(), user.getName(), user.getLastname(),
                isBusiness));
        return usersDTO;
    }

    @Transactional(readOnly = true)
    public List<UserDTO> checkUser(String email) {
        User user = userRepository.findByEmail(email).orElse(null);
        if (user == null) {
            return new ArrayList<UserDTO>();
        }
        Boolean isBusiness = false;
        for (Role role : user.getRoles()) {
            if (role.getName().equals(UserRoleName.ROLE_BUSINESS)) {
                isBusiness = true;
                break;
            }
        }
        List<UserDTO> usersDTO = new ArrayList<UserDTO>();
        usersDTO.add(new UserDTO(user.getId(), user.getEmail(), user.getPassword(), user.getName(), user.getLastname(),
                isBusiness));
        return usersDTO;
    }

    @Transactional
    public User createUser(UserDTO userDTO) {
        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setName(userDTO.getName());
        user.setLastname(userDTO.getLastname());

        List<Role> roles = new ArrayList<Role>();
        Boolean isBusiness = userDTO.getIsBusiness();
        if (isBusiness != null && isBusiness.booleanValue()) {
            roles.add(roleRepository.findByName(UserRoleName.ROLE_BUSINESS).get());
        } else {
            roles.add(roleRepository.findByName(UserRoleName.ROLE_PERSONAL).get());
        }
        user.setRoles(roles);

        return userRepository.save(user);
    }
}

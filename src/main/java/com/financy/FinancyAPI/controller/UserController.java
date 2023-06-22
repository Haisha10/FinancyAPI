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

import com.financy.FinancyAPI.model.dto.UserDTO;
import com.financy.FinancyAPI.model.entity.User;
import com.financy.FinancyAPI.service.UserService;

@CrossOrigin(origins = { "https://haisha10.github.io" })
@RestController
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> getAllUsersDTO() {
        return new ResponseEntity<List<UserDTO>>(userService.findAll(), HttpStatus.OK);
    }

    // GetMapping of username and password as http parameters with param constructor
    @GetMapping("/users/login")
    public ResponseEntity<List<UserDTO>> getUserDTO(@Param("email") String email, @Param("password") String password) {
        return new ResponseEntity<List<UserDTO>>(userService.findByEmailAndPassword(email, password), HttpStatus.OK);
    }

    // Check if email alredy exists in database and return a list of the existing
    // ones with param constructor
    @GetMapping("/users/check")
    public ResponseEntity<List<UserDTO>> checkUser(@Param("email") String email) {
        return new ResponseEntity<List<UserDTO>>(userService.checkUser(email), HttpStatus.OK);
    }

    // PostMapping of userDTO as http body with param constructor
    @PostMapping("/users")
    public ResponseEntity<User> createUserDTO(@RequestBody UserDTO userDTO) {
        return new ResponseEntity<User>(userService.createUser(userDTO), HttpStatus.CREATED);
    }

    @PutMapping("/users")
    public ResponseEntity<User> updateUserDTO(@Param("userId") Long userId, @RequestBody UserDTO userDTO) {
        return new ResponseEntity<User>(userService.updateUser(userId, userDTO), HttpStatus.OK);
    }

    @DeleteMapping("/users")
    public ResponseEntity<User> deleteUserDTO(@Param("userId") Long userId) {
        return new ResponseEntity<User>(userService.deleteUser(userId), HttpStatus.NO_CONTENT);
    }
}

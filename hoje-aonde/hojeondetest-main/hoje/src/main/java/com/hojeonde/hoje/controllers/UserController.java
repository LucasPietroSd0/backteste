package com.hojeonde.hoje.controllers;

import com.hojeonde.hoje.models.User;
import com.hojeonde.hoje.models.UserRequestDTO;
import com.hojeonde.hoje.repositories.UserRepository;
import com.hojeonde.hoje.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;


    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.findAll();
    }
    @GetMapping("/")
    public String hello() {
        return "Aplicação está rodando!";
    }


    @PostMapping
    public ResponseEntity<Void> createUser(@Valid @RequestBody UserRequestDTO userRequestDTO) {
        var idUser = userService.userRequest(userRequestDTO);
        return ResponseEntity.created(URI.create("/users/" + idUser)).build();
    }



    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        var user = userService.findById(id);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.delete(id);
    }

}


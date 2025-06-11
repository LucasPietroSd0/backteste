package com.hojeonde.hoje.controllers;

import com.hojeonde.hoje.models.User;
import com.hojeonde.hoje.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@Valid @PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping
    public ResponseEntity createUser(@Valid @RequestBody  User user) {
        return ResponseEntity.ok(userService.save(user));
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@Valid @PathVariable Long id) {
        userService.delete(id);
    }
}


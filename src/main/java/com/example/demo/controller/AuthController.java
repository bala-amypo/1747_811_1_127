package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(
            @RequestParam String fullName,
            @RequestParam String email,
            @RequestParam String password) {

        User user = userService.registerCustomer(fullName, email, password);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
}

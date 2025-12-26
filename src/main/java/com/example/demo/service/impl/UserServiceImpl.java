package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User registerCustomer(String fullName, String email, String password) {

        userRepository.findByEmail(email).ifPresent(u -> {
            throw new RuntimeException("Email already exists");
        });

        User user = new User();
        user.setFullName(fullName);
        user.setEmail(email);
        user.setPassword(password); // plain text (OK for demo)
        user.setRole(User.Role.CUSTOMER);

        return userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}

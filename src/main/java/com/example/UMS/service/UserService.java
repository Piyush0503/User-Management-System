package com.example.UMS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.UMS.model.User;
import com.example.UMS.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // public User registerUser(User user) {
    //     if (userRepository.existsByEmail(user.getEmail())) {
    //         throw new RuntimeException("Email already exists");
    //     }
    //     user.setPassword(passwordEncoder.encode(user.getPassword()));
    //     return userRepository.save(user);
    // }

    public User getUser(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}

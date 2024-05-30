package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.findAll();
    }

     @PostMapping("/create")
     public User createUser(@RequestBody User user) {
         return userService.save(user);
     }

    @Operation(summary = "Search users", description = "Search users by search term using ILIKE")
    @GetMapping("/search")
    public List<User> searchUsers(
            @Parameter(description = "Search term for user search", required = true)
            @RequestParam String searchTerm) {
        return userService.searchUsers(searchTerm);
    }
}

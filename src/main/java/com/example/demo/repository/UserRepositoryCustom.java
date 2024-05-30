package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.User;

public interface UserRepositoryCustom {
    List<User> findByUsernameILike(String searchTerm);
}

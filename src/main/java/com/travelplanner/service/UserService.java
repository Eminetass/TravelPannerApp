package com.travelplanner.service;

import com.travelplanner.model.User;

import java.util.Optional;

public interface UserService {
    User saveUser(User user);
    Optional<User> findByUsername(String username);
    boolean existsByUsername(String username);
}

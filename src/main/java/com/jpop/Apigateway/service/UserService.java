package com.jpop.Apigateway.service;

import com.jpop.Apigateway.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User findOne(String username);
     ResponseEntity<User> save(User user);
}

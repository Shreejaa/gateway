package com.jpop.Apigateway.service;


import com.jpop.Apigateway.client.UserServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service(value = "userService")
public class UserServiceimpl implements UserService, UserDetailsService {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    UserServiceClient userServiceClient;

    public ResponseEntity<com.jpop.Apigateway.entity.User> save(com.jpop.Apigateway.entity.User user){
        com.jpop.Apigateway.entity.User newuser = new com.jpop.Apigateway.entity.User();
        newuser.setFirstname(user.getFirstname());
        newuser.setLastname(user.getLastname());
        newuser.setPhoneno(user.getPhoneno());
        newuser.setUseremail(user.getUseremail());
        newuser.setUsername(user.getUsername());
        newuser.setPassword(passwordEncoder.encode(user.getPassword()));
        return userServiceClient.createUser(newuser);
    }
    @Override
    public com.jpop.Apigateway.entity.User findOne(String username) {
        com.jpop.Apigateway.entity.User user= userServiceClient.findByUsername(username).getBody();
        return user;
    }

    public UserDetails loadUserByUsername(String userId) throws
            UsernameNotFoundException {
        com.jpop.Apigateway.entity.User user = userServiceClient.findByUsername(userId).getBody();
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new User(
                user.getUsername(), user.getPassword(), new ArrayList<>());
    }
}

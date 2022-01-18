package com.jpop.Apigateway.client;


import com.jpop.Apigateway.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@FeignClient(name = "user-service",fallback = UserFallBack.class)
public interface UserServiceClient {

    @PostMapping("/users")
    ResponseEntity<User> createUser(@RequestBody User user);

    @GetMapping("/users/username/{username}")
    ResponseEntity<User> findByUsername(@PathVariable String username);
}

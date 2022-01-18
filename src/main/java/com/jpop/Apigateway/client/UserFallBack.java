package com.jpop.Apigateway.client;

import com.jpop.Apigateway.entity.User;
import com.jpop.Apigateway.util.ResponseEntityUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;


@Component
public class UserFallBack implements UserServiceClient {
    private static final String USER_SERVICE="User";

    @Override
    public ResponseEntity<User> createUser(User user) {
        return new ResponseEntityUtil().getServiceUnavailableMessage(USER_SERVICE);
    }

    @Override
    public ResponseEntity<User> findByUsername(String username) {
        return new ResponseEntityUtil().getServiceUnavailableMessage(USER_SERVICE);
    }

}

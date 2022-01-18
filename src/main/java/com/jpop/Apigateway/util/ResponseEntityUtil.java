package com.jpop.Apigateway.util;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseEntityUtil<T> {
    public ResponseEntity<T> getServiceUnavailableMessage(String service){
        return new ResponseEntity<T>((T) new CustomErrorMessage(service+" Service unavailable"),new HttpHeaders(), HttpStatus.SERVICE_UNAVAILABLE);
    }
}

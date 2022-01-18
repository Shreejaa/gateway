package com.jpop.Apigateway.entity;

public class JWTresponse {
    private static final long serialVersionUID = -8091879091924046844L;
    private String jwttoken=null;

    public JWTresponse(String jwttoken) {
        this.jwttoken = jwttoken;
    }

    public String getToken() {
        return this.jwttoken;
    }
}

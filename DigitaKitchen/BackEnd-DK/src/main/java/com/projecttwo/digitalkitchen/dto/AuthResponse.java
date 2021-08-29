package com.projecttwo.digitalkitchen.dto;

public class AuthResponse {

    private final String jwt;
    private  String message;

    public AuthResponse(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

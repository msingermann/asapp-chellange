package com.asapp.backend.challenge.application.model.responses;

public class LoginResponse {

    private final int id;
    private final String token;

    public LoginResponse(int id, String token) {
        this.id = id;
        this.token = token;
    }

    public int getId() {
        return id;
    }

    public String getToken() {
        return token;
    }
}

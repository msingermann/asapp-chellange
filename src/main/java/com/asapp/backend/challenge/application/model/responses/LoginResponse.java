package com.asapp.backend.challenge.application.model.responses;

public class LoginResponse {

    private final long id;
    private final String token;

    public LoginResponse(long id, String token) {
        this.id = id;
        this.token = token;
    }

    public long getId() {
        return id;
    }

    public String getToken() {
        return token;
    }
}

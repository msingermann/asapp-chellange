package com.asapp.backend.challenge.application.model.responses;

public class CreateUserResponse {

    private final int id;

    public CreateUserResponse(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}

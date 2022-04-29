package com.asapp.backend.challenge.application.model.requests;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateUserRequest {

    private final String name;
    private final String password;

    @JsonCreator
    public CreateUserRequest(@JsonProperty(value = "name", required = true) String name,
                             @JsonProperty(value = "password", required = true) String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

}

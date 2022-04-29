package com.asapp.backend.challenge.application.services;

import com.asapp.backend.challenge.application.model.requests.LoginRequest;
import com.asapp.backend.challenge.application.model.responses.LoginResponse;

public interface AuthService {

    public LoginResponse login(LoginRequest loginRequest);

}

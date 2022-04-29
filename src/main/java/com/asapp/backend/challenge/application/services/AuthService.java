package com.asapp.backend.challenge.application.services;

import com.asapp.backend.challenge.application.model.requests.LoginRequest;
import com.asapp.backend.challenge.application.model.responses.LoginResponse;

/**
 * Authorization service.
 */
public interface AuthService {

    /**
     * Validate a user and returns an Authorization Token.
     *
     * @param loginRequest Request with user information.
     * @return User id and auth token.
     */
    LoginResponse login(LoginRequest loginRequest);

}

package com.asapp.backend.challenge.application.controllers;

import com.asapp.backend.challenge.application.model.requests.LoginRequest;
import com.asapp.backend.challenge.application.model.responses.LoginResponse;
import com.asapp.backend.challenge.application.services.AuthService;
import com.asapp.backend.challenge.application.utils.Path;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @RequestMapping(value = Path.LOGIN, method = RequestMethod.POST)
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        LOGGER.debug("Login request received.");
        LoginResponse response = authService.login(loginRequest);
        return ResponseEntity.ok().body(response);
    }
}

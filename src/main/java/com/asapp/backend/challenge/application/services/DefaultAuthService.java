package com.asapp.backend.challenge.application.services;

import com.asapp.backend.challenge.application.exceptions.LoginFailedException;
import com.asapp.backend.challenge.application.model.data.User;
import com.asapp.backend.challenge.application.model.requests.LoginRequest;
import com.asapp.backend.challenge.application.model.responses.LoginResponse;
import com.asapp.backend.challenge.application.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class DefaultAuthService implements AuthService {

    private UsersRepository usersRepository;

    @Autowired
    public DefaultAuthService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public LoginResponse login(LoginRequest loginRequest) {
        Optional<User> maybeUser = usersRepository.findByNameAndPassword(loginRequest.getName(), loginRequest.getPassword());
        if (maybeUser.isEmpty() || !maybeUser.get().getPassword().equals(loginRequest.getPassword())) {
            throw new LoginFailedException("Wrong User or Password");
        }
        //TODO generate login token and store maybe use an encrypted JWT?
        return new LoginResponse(maybeUser.get().getId(), UUID.randomUUID().toString());
    }
}

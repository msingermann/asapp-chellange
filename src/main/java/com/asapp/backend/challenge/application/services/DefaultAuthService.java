package com.asapp.backend.challenge.application.services;

import com.asapp.backend.challenge.application.exceptions.LoginFailedException;
import com.asapp.backend.challenge.application.exceptions.UnauthorizedException;
import com.asapp.backend.challenge.application.model.data.AuthToken;
import com.asapp.backend.challenge.application.model.data.User;
import com.asapp.backend.challenge.application.model.requests.LoginRequest;
import com.asapp.backend.challenge.application.model.responses.LoginResponse;
import com.asapp.backend.challenge.application.repositories.AuthTokenRepository;
import com.asapp.backend.challenge.application.repositories.UsersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Optional;
import java.util.UUID;

@Component
public class DefaultAuthService implements AuthService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultAuthService.class);

    private static final String BEARER_PREFIX = "bearer ";

    private UsersRepository usersRepository;
    private AuthTokenRepository authTokenRepository;



    @Autowired
    public DefaultAuthService(UsersRepository usersRepository,
                              AuthTokenRepository authTokenRepository) {
        this.usersRepository = usersRepository;
        this.authTokenRepository = authTokenRepository;
    }

    /**
     * {@inheritDoc}
     */
    public LoginResponse login(LoginRequest loginRequest) {
        Optional<User> maybeUser = usersRepository.findByNameAndPassword(loginRequest.getName(), loginRequest.getPassword());
        if (maybeUser.isEmpty() || !maybeUser.get().getPassword().equals(loginRequest.getPassword())) {
            LOGGER.debug("Login failed. Wrong user or password. User: %s, exists: %s", loginRequest.getName(), maybeUser.isPresent());
            throw new LoginFailedException("Wrong User or Password");
        }

        //Decided to use UUID as a key and allow the user to login from multiple devices generating different tokens.
        AuthToken token = new AuthToken(UUID.randomUUID().toString(), maybeUser.get().getId());
        authTokenRepository.save(token);

        return new LoginResponse(maybeUser.get().getId(), BEARER_PREFIX + token.getToken());
    }

    public void validateToken(String authHeaderValue) {
        String token = extractToken(authHeaderValue);
        Optional<AuthToken> authToken = authTokenRepository.findById(token);
        if(authToken.isEmpty()) {
            LOGGER.debug("Authorization token is not valid or expired.");
            throw new UnauthorizedException();
        }
    }

    private String extractToken(String authHeaderValue) {
        if(StringUtils.startsWithIgnoreCase(authHeaderValue, BEARER_PREFIX)) {
            return authHeaderValue.substring(BEARER_PREFIX.length());
        }
        LOGGER.debug("Authorization token is not valid or expired.");
        throw new UnauthorizedException();
    }
}

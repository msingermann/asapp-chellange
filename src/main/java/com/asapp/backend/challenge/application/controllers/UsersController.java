package com.asapp.backend.challenge.application.controllers;

import com.asapp.backend.challenge.application.model.responses.CreateUserResponse;
import com.asapp.backend.challenge.application.model.data.User;
import com.asapp.backend.challenge.application.model.requests.CreateUserRequest;
import com.asapp.backend.challenge.application.services.UsersService;
import com.asapp.backend.challenge.application.transformers.UsersTransformer;
import com.asapp.backend.challenge.application.utils.Path;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class UsersController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UsersController.class);

    private final UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @RequestMapping(value = Path.USERS, method = RequestMethod.POST)
    public ResponseEntity<CreateUserResponse> createUser(@RequestBody CreateUserRequest createUserRequest) throws ResponseStatusException {
        LOGGER.debug("Create Users request received.");
        User user = usersService.createUser(createUserRequest.getName(), createUserRequest.getPassword());
        return ResponseEntity.ok().body(UsersTransformer.transform(user));
    }

}

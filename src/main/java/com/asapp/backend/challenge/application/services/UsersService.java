package com.asapp.backend.challenge.application.services;

import com.asapp.backend.challenge.application.model.data.User;

/**
 * Users Service.
 */
public interface UsersService {

    /**
     * Creates a User.
     *
     * @param name     User name.
     * @param password User password.
     * @return Created user with Id.
     */
    User createUser(String name, String password);

}

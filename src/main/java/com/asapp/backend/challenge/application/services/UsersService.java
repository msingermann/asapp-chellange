package com.asapp.backend.challenge.application.services;

import com.asapp.backend.challenge.application.model.data.User;

public interface UsersService {

    public User createUser(String name, String password);

}

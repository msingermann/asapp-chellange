package com.asapp.backend.challenge.application.services;

import com.asapp.backend.challenge.application.exceptions.NameAlreadyTakenException;
import com.asapp.backend.challenge.application.model.data.User;
import com.asapp.backend.challenge.application.repositories.UsersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Optional;

@Component
public class DefaultUsersService implements UsersService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultUsersService.class);
    private final UsersRepository usersRepository;

    @Autowired
    public DefaultUsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    /**
     * {@inheritDoc}
     */
    @Transactional
    public User createUser(String name, String password) {
        Optional<User> previousUserWithThatName = usersRepository.findByName(name);
        if (previousUserWithThatName.isPresent()) {
            LOGGER.error("Name %s is already taken.", name);
            throw new NameAlreadyTakenException("Name " + name + " is already taken.");
        }
        User user = new User(name, password);
        User persistedUser = usersRepository.save(user);
        LOGGER.debug("User id: %s, name: %s created.", persistedUser.getId(), persistedUser.getName());
        return user;
    }
}

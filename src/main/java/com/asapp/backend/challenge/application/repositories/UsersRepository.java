package com.asapp.backend.challenge.application.repositories;

import com.asapp.backend.challenge.application.model.data.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Repository to manage Users.
 */
public interface UsersRepository extends CrudRepository<User, Integer> {

    /**
     * Finds users by name and password to check if password is correct.
     *
     * @param name     User name.
     * @param password User password.
     * @return Optional of User. Empty if not present or password is not matched.
     */
    Optional<User> findByNameAndPassword(String name, String password);

    /**
     * Finds users by Name to check if the name is taken.
     *
     * @param name User name.
     * @return Returns a user if the name is taken.
     */
    Optional<User> findByName(String name);
}

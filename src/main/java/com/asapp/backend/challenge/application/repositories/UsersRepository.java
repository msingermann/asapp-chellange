package com.asapp.backend.challenge.application.repositories;

import com.asapp.backend.challenge.application.model.data.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UsersRepository extends CrudRepository<User, Integer> {

    public Optional<User> findByNameAndPassword(String name, String password);
    public Optional<User> findByName(String name);
//    CREATE TABLE IF NOT EXISTS users (id INTEGER PRIMARY KEY AUTOINCREMENT, name varchar(255) NOT NULL,password varchar(255));
}

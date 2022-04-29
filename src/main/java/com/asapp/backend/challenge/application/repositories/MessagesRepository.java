package com.asapp.backend.challenge.application.repositories;

import com.asapp.backend.challenge.application.model.data.Message;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository to manage Messages.
 */
public interface MessagesRepository extends CrudRepository<Message, Integer> {
}

package com.asapp.backend.challenge.application.repositories;

import com.asapp.backend.challenge.application.model.data.Message;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Repository to manage Messages.
 */
public interface MessagesRepository extends CrudRepository<Message, Integer> {

    @Transactional(readOnly = true)
    @Query(value = "SELECT * FROM messages WHERE id >= (:start) AND recipient = (:recipient) ORDER BY id LIMIT (:limit)", nativeQuery = true)
    List<Message> getMessagesByRecipientFrom(long recipient, int start, int limit);

}

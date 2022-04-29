package com.asapp.backend.challenge.application.repositories;

import com.asapp.backend.challenge.application.model.data.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessagesRepository extends CrudRepository<Message, Integer> {

//    public Message saveMessage(int sender, int receiver, String type, String metadata);

}

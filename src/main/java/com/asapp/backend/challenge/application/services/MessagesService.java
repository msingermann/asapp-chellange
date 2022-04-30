package com.asapp.backend.challenge.application.services;

import com.asapp.backend.challenge.application.model.dto.MessageDTO;
import com.asapp.backend.challenge.application.model.requests.SendMessageRequest;
import com.asapp.backend.challenge.application.model.responses.CreateMessageResponse;

import java.util.List;

/**
 * Messages Service.
 */
public interface MessagesService {

    /**
     * Creates a Message.
     *
     * @param sendMessageRequest Message request.
     * @return Message Id and timestamp.
     */
    CreateMessageResponse sendMessage(SendMessageRequest sendMessageRequest);

    List<MessageDTO> getMessages(long recipient, int start, int limit);
}

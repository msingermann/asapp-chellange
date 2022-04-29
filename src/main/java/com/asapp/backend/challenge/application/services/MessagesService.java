package com.asapp.backend.challenge.application.services;

import com.asapp.backend.challenge.application.model.requests.SendMessageRequest;
import com.asapp.backend.challenge.application.model.responses.CreateMessageResponse;

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

}

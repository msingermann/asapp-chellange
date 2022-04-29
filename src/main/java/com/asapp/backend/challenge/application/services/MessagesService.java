package com.asapp.backend.challenge.application.services;

import com.asapp.backend.challenge.application.model.requests.SendMessageRequest;
import com.asapp.backend.challenge.application.model.responses.CreateMessageResponse;

public interface MessagesService {

    public CreateMessageResponse sendMessage(SendMessageRequest sendMessageRequest);

}

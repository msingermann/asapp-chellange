package com.asapp.backend.challenge.application.services;

import com.asapp.backend.challenge.application.model.data.Message;
import com.asapp.backend.challenge.application.model.requests.SendMessageRequest;
import com.asapp.backend.challenge.application.model.requests.messages.MessageContent;
import com.asapp.backend.challenge.application.model.responses.CreateMessageResponse;
import com.asapp.backend.challenge.application.repositories.MessagesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DefaultMessagesService implements MessagesService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultMessagesService.class);

    private MessagesRepository messagesRepository;

    @Autowired
    public DefaultMessagesService(MessagesRepository messagesRepository) {
        this.messagesRepository = messagesRepository;
    }

    public CreateMessageResponse sendMessage(SendMessageRequest sendMessageRequest) {
        MessageContent content = sendMessageRequest.getContent();
        Message message = new Message(sendMessageRequest.getSender(), sendMessageRequest.getRecipient(), content.getType(), content.getMetadata());
        Message persistedMessage = messagesRepository.save(message);
        LOGGER.debug("Persisted Message id: %s. From user: %s to user: %s.", persistedMessage.getId(), persistedMessage.getSender(), persistedMessage.getRecipient());
        return new CreateMessageResponse(persistedMessage.getId(), persistedMessage.getTimestamp());
    }
}

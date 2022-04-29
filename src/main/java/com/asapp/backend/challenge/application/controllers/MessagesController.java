package com.asapp.backend.challenge.application.controllers;

import com.asapp.backend.challenge.application.model.requests.SendMessageRequest;
import com.asapp.backend.challenge.application.model.responses.CreateMessageResponse;
import com.asapp.backend.challenge.application.services.MessagesService;
import com.asapp.backend.challenge.application.utils.Path;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessagesController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessagesController.class);
    private final MessagesService messagesService;

    @Autowired
    public MessagesController(MessagesService messagesService) {
        this.messagesService = messagesService;
    }

    @RequestMapping(value = Path.MESSAGES, method = RequestMethod.POST)
    public ResponseEntity<CreateMessageResponse> sendMessage(@RequestBody SendMessageRequest sendMessageRequest) {
        LOGGER.debug("Send message request received.");
        CreateMessageResponse response = messagesService.sendMessage(sendMessageRequest);
        return ResponseEntity.ok().body(response);
    }
}

package com.asapp.backend.challenge.application.controllers;

import com.asapp.backend.challenge.application.model.data.Message;
import com.asapp.backend.challenge.application.model.dto.MessageDTO;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MessagesController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessagesController.class);
    private final MessagesService messagesService;

    @Autowired
    public MessagesController(MessagesService messagesService) {
        this.messagesService = messagesService;
    }

    /**
     * Send a message from one user to another.
     *
     * @param sendMessageRequest {@link SendMessageRequest}.
     * @return {@link CreateMessageResponse}.
     */
    @RequestMapping(value = Path.MESSAGES, method = RequestMethod.POST)
    public ResponseEntity<CreateMessageResponse> sendMessage(@RequestBody SendMessageRequest sendMessageRequest) {
        sendMessageRequest.getContent().validate();
        LOGGER.debug("Send message request received.");
        CreateMessageResponse response = messagesService.sendMessage(sendMessageRequest);
        return ResponseEntity.ok().body(response);
    }

    /**
     * Fetch all existing messages to a given recipient, within a range of message IDs.

     * @param recipient User ID of recipient.
     * @param start Starting message ID. Messages will be returned in increasing order of message ID, starting from this value (or the next lowest value stored in the database).
     * @param limit Limit the response to this many messages (Default = 100).
     * @return List of {@link Message}.
     */
    @RequestMapping(value = Path.MESSAGES, method = RequestMethod.GET)
    public ResponseEntity<List<MessageDTO>> getMessages(@RequestParam long recipient,
                                                        @RequestParam int start,
                                                        @RequestParam(defaultValue = "100") int limit) {
        LOGGER.debug("Get messages request received.");
        List<MessageDTO> response = messagesService.getMessages(recipient, start, limit);
        return ResponseEntity.ok().body(response);
    }
}

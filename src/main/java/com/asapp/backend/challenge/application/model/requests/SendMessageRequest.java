package com.asapp.backend.challenge.application.model.requests;

import com.asapp.backend.challenge.application.model.requests.messages.MessageContent;
import com.fasterxml.jackson.annotation.JsonCreator;

public class SendMessageRequest {

    private int sender;

    private int recipient;

    private MessageContent content;

    @JsonCreator
    public SendMessageRequest(int sender, int recipient, MessageContent content) {
        this.sender = sender;
        this.recipient = recipient;
        this.content = content;
    }

    public int getSender() {
        return sender;
    }

    public int getRecipient() {
        return recipient;
    }

    public MessageContent getContent() {
        return content;
    }
}

package com.asapp.backend.challenge.application.model.requests;

import com.asapp.backend.challenge.application.model.requests.messages.MessageContent;
import com.fasterxml.jackson.annotation.JsonCreator;

public class SendMessageRequest {

    private final long sender;

    private final long recipient;

    private final MessageContent content;

    @JsonCreator
    public SendMessageRequest(long sender, long recipient, MessageContent content) {
        this.sender = sender;
        this.recipient = recipient;
        this.content = content;
    }

    public long getSender() {
        return sender;
    }

    public long getRecipient() {
        return recipient;
    }

    public MessageContent getContent() {
        return content;
    }
}

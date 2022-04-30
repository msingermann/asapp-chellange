package com.asapp.backend.challenge.application.model.dto;

import java.util.Date;

public class MessageDTO {

    private final long id;

    private final long sender;

    private final long recipient;

    private final Date timestamp;

    private final MessageContentDTO content;

    public MessageDTO(long id, long sender, long recipient, Date timestamp, MessageContentDTO content) {
        this.id = id;
        this.timestamp = timestamp;
        this.sender = sender;
        this.recipient = recipient;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public long getSender() {
        return sender;
    }

    public long getRecipient() {
        return recipient;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public MessageContentDTO getContent() {
        return content;
    }
}

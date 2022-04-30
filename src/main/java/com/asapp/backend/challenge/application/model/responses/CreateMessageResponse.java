package com.asapp.backend.challenge.application.model.responses;

import java.util.Date;

public class CreateMessageResponse {

    private final long id;
    private final Date timestamp;

    public CreateMessageResponse(long id, Date timestamp) {
        this.id = id;
        this.timestamp = timestamp;
    }

    public long getId() {
        return id;
    }

    public Date getTimestamp() {
        return timestamp;
    }
}

package com.asapp.backend.challenge.application.model.responses;

import java.util.Date;

public class CreateMessageResponse {

    private final int id;
    private final Date timestamp;

    public CreateMessageResponse(int id, Date timestamp) {
        this.id = id;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public Date getTimestamp() {
        return timestamp;
    }
}

package com.asapp.backend.challenge.application.model.dto;

public abstract class MessageContentDTO {

    private final String type;

    public MessageContentDTO(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

}

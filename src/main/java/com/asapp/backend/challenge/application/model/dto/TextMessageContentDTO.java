package com.asapp.backend.challenge.application.model.dto;

public class TextMessageContentDTO extends MessageContentDTO {

    private final String text;

    public TextMessageContentDTO(String text) {
        super("text");
        this.text = text;
    }

    public String getText() {
        return text;
    }
}

package com.asapp.backend.challenge.application.model.requests.messages;

import com.asapp.backend.challenge.application.model.MessageContentTypes;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

public class TextMessageContent extends MessageContent {

    private Map<String, Object> metadata;

    @JsonCreator
    public TextMessageContent(
            @JsonProperty("text") String text) {
        super(MessageContentTypes.TEXT.name());
        metadata = new HashMap<>();
        metadata.put("text", text);
    }

    @Override
    public Map<String, Object> getMetadata() {
        return metadata;
    }

}

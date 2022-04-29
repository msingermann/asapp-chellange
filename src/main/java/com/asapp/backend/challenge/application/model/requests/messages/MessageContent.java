package com.asapp.backend.challenge.application.model.requests.messages;

import com.asapp.backend.challenge.application.exceptions.ContentTypeNotAvailableException;
import com.asapp.backend.challenge.application.model.MessageContentTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.Map;

/**
 * Request object to create a target change notification.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = TextMessageContent.class, name = "text"),
        @JsonSubTypes.Type(value = ImageMessageContent.class, name = "image"),
        @JsonSubTypes.Type(value = VideoMessageContent.class, name = "video")
})
public abstract class MessageContent {

    private final String type;

    public MessageContent(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public abstract Map<String, Object> getMetadata();
}

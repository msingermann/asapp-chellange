package com.asapp.backend.challenge.application.model.requests.messages;

import com.asapp.backend.challenge.application.model.MessageContentTypes;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

public class VideoMessageContent extends MessageContent {

    private Map<String, Object> metadata;

    @JsonCreator
    public VideoMessageContent(
            @JsonProperty("url") String url,
            @JsonProperty("source") String source) {
        super(MessageContentTypes.VIDEO.name());
        metadata = new HashMap<>();

        //TODO validate url

        metadata.put("url", url);

        //TODO source should be a enum (youtube, vimeo)
        metadata.put("source", source);
    }


    @Override
    public Map<String, Object> getMetadata() {
        return metadata;
    }
}

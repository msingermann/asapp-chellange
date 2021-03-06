package com.asapp.backend.challenge.application.model.requests.messages;

import com.asapp.backend.challenge.application.model.MessageContentTypes;
import com.asapp.backend.challenge.application.utils.Utils;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

public class VideoMessageContent extends MessageContent {

    private final Map<String, Object> metadata;

    @JsonCreator
    public VideoMessageContent(
            @JsonProperty("url") String url,
            @JsonProperty("source") String source) {
        super(MessageContentTypes.VIDEO.name());
        metadata = new HashMap<>();
        metadata.put("url", url);
        metadata.put("source", source);
    }


    @Override
    public Map<String, Object> getMetadata() {
        return metadata;
    }

    @Override
    public void validate() {
        Utils.validateURI((String) metadata.get("url"));
        VideoSource.resolve((String) metadata.get("source"));
    }
}

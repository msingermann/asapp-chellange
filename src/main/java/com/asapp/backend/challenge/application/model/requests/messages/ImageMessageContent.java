package com.asapp.backend.challenge.application.model.requests.messages;

import com.asapp.backend.challenge.application.model.MessageContentTypes;
import com.asapp.backend.challenge.application.utils.Utils;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

public class ImageMessageContent extends MessageContent {

    private final Map<String, Object> metadata;

    @JsonCreator
    public ImageMessageContent(
            @JsonProperty("url") String url,
            @JsonProperty("height") int height,
            @JsonProperty("width") int width) {
        super(MessageContentTypes.IMAGE.name());
        metadata = new HashMap<>();
        metadata.put("url", url);
        metadata.put("height", height);
        metadata.put("width", width);
    }

    @Override
    public Map<String, Object> getMetadata() {
        return metadata;
    }

    @Override
    public void validate() {
        Utils.validateURI((String) metadata.get("url"));
    }
}

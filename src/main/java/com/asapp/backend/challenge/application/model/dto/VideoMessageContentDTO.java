package com.asapp.backend.challenge.application.model.dto;

public class VideoMessageContentDTO extends MessageContentDTO {

    private final String url;
    private final String source;

    public VideoMessageContentDTO(String url, String source) {
        super("video");
        this.url = url;
        this.source = source;
    }

    public String getUrl() {
        return url;
    }

    public String getSource() {
        return source;
    }
}


package com.asapp.backend.challenge.application.model.dto;

public class ImageMessageContentDTO extends MessageContentDTO {

    private final String url;
    private final int width;
    private final int height;

    public ImageMessageContentDTO(String url, int width, int height) {
        super("image");
        this.url = url;
        this.width = width;
        this.height = height;
    }

    public String getUrl() {
        return url;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}

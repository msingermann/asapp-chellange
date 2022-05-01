package com.asapp.backend.challenge.application.model.requests.messages;


import com.asapp.backend.challenge.application.exceptions.SourceNotValidException;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public enum VideoSource {

    YOUTUBE("youtube"),

    VIMEO("vimeo");

    private static final Map<String, VideoSource> INDEXED_VIDEO_SOURCES;

    static {
        INDEXED_VIDEO_SOURCES = new HashMap<>();

        for (VideoSource deploymentType : VideoSource.values()) {
            INDEXED_VIDEO_SOURCES.put(deploymentType.getDisplayName(), deploymentType);
        }
    }

    private final String displayName;

    VideoSource(String displayName) {
        this.displayName = displayName;
    }

    public static VideoSource resolve(String displayName) {
        return Optional.ofNullable(INDEXED_VIDEO_SOURCES.get(displayName))
                .orElseThrow(() -> new SourceNotValidException("Video source is not valid."));
    }

    public String getDisplayName() {
        return displayName;
    }
}

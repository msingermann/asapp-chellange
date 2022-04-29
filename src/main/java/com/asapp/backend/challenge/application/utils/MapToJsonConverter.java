package com.asapp.backend.challenge.application.utils;

import com.asapp.backend.challenge.application.exceptions.MetadataParsingException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;

public class MapToJsonConverter {
    private static final Logger LOGGER = LoggerFactory.getLogger(MapToJsonConverter.class);

    private final static ObjectMapper objectMapper = new ObjectMapper();

    public static String convertMapToJsonString(Map<String, Object> meta) {
        try {
            return objectMapper.writeValueAsString(meta);
        } catch (JsonProcessingException e) {
            LOGGER.error("Failed to parse Map to Json", e);
            throw new MetadataParsingException();
        }
    }

    public static Map<String, Object> convertJsonStringtoMap(String dbData) {
        try {
            return objectMapper.readValue(dbData, new TypeReference<>() {
            });
        } catch (IOException e) {
            LOGGER.error("Failed to parse Json from DB. content: %s",dbData, e);
            throw new MetadataParsingException();
        }
    }

}

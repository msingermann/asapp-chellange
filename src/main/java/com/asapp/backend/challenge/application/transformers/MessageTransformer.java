package com.asapp.backend.challenge.application.transformers;

import com.asapp.backend.challenge.application.model.MessageContentTypes;
import com.asapp.backend.challenge.application.model.data.Message;
import com.asapp.backend.challenge.application.model.dto.ImageMessageContentDTO;
import com.asapp.backend.challenge.application.model.dto.MessageContentDTO;
import com.asapp.backend.challenge.application.model.dto.MessageDTO;
import com.asapp.backend.challenge.application.model.dto.TextMessageContentDTO;
import com.asapp.backend.challenge.application.model.dto.VideoMessageContentDTO;

public class MessageTransformer {

    public static MessageDTO transformToDTO(Message message) {
        MessageContentDTO content = null;
        switch (MessageContentTypes.valueOf(message.getType())) {
            case TEXT:
                content = new TextMessageContentDTO(
                        (String) message.getMetadata().get("text"));
                break;
            case IMAGE:
                content = new ImageMessageContentDTO(
                        (String) message.getMetadata().get("url"),
                        (int) message.getMetadata().get("width"),
                        (int) message.getMetadata().get("height"));
                break;
            case VIDEO:
                content = new VideoMessageContentDTO(
                        (String) message.getMetadata().get("url"),
                        (String) message.getMetadata().get("source"));
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + message.getType());
        }
        return new MessageDTO(message.getId(), message.getSender(), message.getRecipient(), message.getTimestamp(), content);
    }
}

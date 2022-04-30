package com.asapp.backend.challenge.application.model.data;

import com.asapp.backend.challenge.application.utils.MapToJsonConverter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.Map;
import java.util.Objects;

/**
 * Message entity.
 */
@Entity
@Table(name = "messages")
public class Message {

    /**
     * Message Id.
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    /**
     * Message Sender Id.
     */
    @Column(name = "sender", nullable = false)
    private long sender;

    /**
     * Message Recipient Id.
     */
    @Column(name = "recipient", nullable = false)
    private long recipient;

    /**
     * Message Content type {@link com.asapp.backend.challenge.application.model.MessageContentTypes}.
     */
    @Column(name = "type", nullable = false)
    private String type;

    /**
     * Content metadata.
     */
    @Column(name = "metadata", nullable = false)
    private String metadata;

    /**
     * Creation date.
     */
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "timestamp")
    private Date timestamp;

    public Message() {
    }

    public Message(long sender, long recipient, String type, Map<String, Object> metadata) {
        this.sender = sender;
        this.recipient = recipient;
        this.type = type;
        this.metadata = MapToJsonConverter.convertMapToJsonString(metadata);
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getSender() {
        return sender;
    }

    public void setSender(int sender) {
        this.sender = sender;
    }

    public long getRecipient() {
        return recipient;
    }

    public void setRecipient(int recipient) {
        this.recipient = recipient;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<String, Object> getMetadata() {
        return MapToJsonConverter.convertJsonStringtoMap(metadata);
    }

    public void setMetadata(Map<String, Object> metadata) {
        this.metadata = MapToJsonConverter.convertMapToJsonString(metadata);
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setMetadata(String metadata) {
        this.metadata = metadata;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return id == message.id && sender == message.sender && recipient == message.recipient && Objects.equals(type, message.type) && Objects.equals(metadata, message.metadata) && Objects.equals(timestamp, message.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sender, recipient, type, metadata, timestamp);
    }
}

package com.asapp.backend.challenge.application.model.data;

import com.asapp.backend.challenge.application.utils.MapToJsonConverter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.type.BlobType;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.Map;

@Entity
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name = "sender", nullable = false)
    private int sender;

    @Column(name = "recipient", nullable = false)
    private int recipient;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "metadata", nullable = false)
    private String metadata;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "timestamp")
    private Date timestamp;

    public Message() {
    }

    public Message(int sender, int recipient, String type, Map<String, Object> metadata) {
        this.sender = sender;
        this.recipient = recipient;
        this.type = type;
        this.metadata = MapToJsonConverter.convertToDatabaseColumn(metadata);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSender() {
        return sender;
    }

    public void setSender(int sender) {
        this.sender = sender;
    }

    public int getRecipient() {
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
        return MapToJsonConverter.convertToEntityAttribute(metadata);
    }

    public void setMetadata(Map<String, Object> metadata) {
        this.metadata = MapToJsonConverter.convertToDatabaseColumn(metadata);
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
}

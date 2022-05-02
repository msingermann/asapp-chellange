package com.asapp.backend.challenge.application.model.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "tokens")
public class AuthToken {

    /**
     * Message Id.
     */
    @Id
    private String token;

    @Column(name = "user_id", nullable = false)
    private long user;

    @Column(name = "timestamp", insertable = false)
    private Date timestamp;

    public AuthToken(String token, long user) {
        this.token = token;
        this.user = user;
    }

    public AuthToken() {

    }

    public String getToken() {
        return token;
    }

    public long getUser() {
        return user;
    }

    public Date getTimestamp() {
        return timestamp;
    }
}

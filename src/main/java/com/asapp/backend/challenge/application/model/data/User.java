package com.asapp.backend.challenge.application.model.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * User entity.
 */
@Entity
@Table(name = "users")
public class User {

    /**
     * User Id.
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    /**
     * User Name (must be unique).
     */
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * User Password Hashed.
     */
    @Column(name = "password", nullable = false)
    private String password;

    public User(String name, String password) {
        super();
        this.name = name;
        this.password = password;
    }

    public User(){
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

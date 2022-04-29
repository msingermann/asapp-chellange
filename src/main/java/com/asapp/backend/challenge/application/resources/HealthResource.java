package com.asapp.backend.challenge.application.resources;

public class HealthResource {

    private final String health;

    public HealthResource(String health) {
        this.health = health;
    }

    public String getHealth() {
        return health;
    }
}
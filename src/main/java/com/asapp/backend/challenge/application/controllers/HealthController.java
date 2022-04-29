package com.asapp.backend.challenge.application.controllers;

import com.asapp.backend.challenge.application.resources.HealthResource;
import com.asapp.backend.challenge.application.utils.Path;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HealthController.class);

    /**
     * Health check endpoint.
     *
     * @return {@link HealthResource}.
     */
    @RequestMapping(value = Path.HEALTH, method = RequestMethod.POST)
    public ResponseEntity<HealthResource> getHealth() {
        LOGGER.debug("Health Check request received.");
        return ResponseEntity.ok().body(new HealthResource("OK"));
    }

}

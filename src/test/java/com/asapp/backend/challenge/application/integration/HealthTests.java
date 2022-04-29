package com.asapp.backend.challenge.application.integration;

import com.asapp.backend.challenge.application.utils.Path;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;

public class HealthTests extends IntegrationTests {

    @Test
    public void getHealth() {
        RestAssured.given().port(port).contentType(ContentType.JSON).given().post(Path.HEALTH).then()
                .statusCode(HttpStatus.SC_OK)
                .and().body("health", equalTo("OK"));
    }

}

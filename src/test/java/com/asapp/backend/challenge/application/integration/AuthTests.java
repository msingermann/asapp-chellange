package com.asapp.backend.challenge.application.integration;

import com.asapp.backend.challenge.application.model.requests.CreateUserRequest;
import com.asapp.backend.challenge.application.model.requests.LoginRequest;
import com.asapp.backend.challenge.application.utils.Path;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.notNullValue;

public class AuthTests extends IntegrationTests {

    @Test
    public void loginUser() {
        CreateUserRequest payload = new CreateUserRequest("newuser", "pa$$word");
        RestAssured.given().port(port).contentType(ContentType.JSON).given().body(payload).post(Path.USERS).then()
                .statusCode(HttpStatus.SC_OK)
                .and().body("id", notNullValue());

        LoginRequest loginPayload = new LoginRequest("newuser", "pa$$word");
        RestAssured.given().port(port).contentType(ContentType.JSON).given().body(loginPayload).post(Path.LOGIN).then()
                .statusCode(HttpStatus.SC_OK)
                .and().body("id", notNullValue())
                .and().body("token", notNullValue());
    }

}
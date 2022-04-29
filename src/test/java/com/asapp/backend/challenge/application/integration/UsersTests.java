package com.asapp.backend.challenge.application.integration;

import com.asapp.backend.challenge.application.model.requests.CreateUserRequest;
import com.asapp.backend.challenge.application.utils.Path;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class UsersTests extends IntegrationTests {

    @Test
    public void createUser() {
        CreateUserRequest payload = new CreateUserRequest("user", "pa$$word");
        RestAssured.given().port(port).contentType(ContentType.JSON).given().body(payload).post(Path.USERS).then()
                .statusCode(HttpStatus.SC_OK)
                .and().body("id", notNullValue());
    }

    @Test
    public void nameAlreadyTaken() {
        String name = "usertaken";
        CreateUserRequest payload = new CreateUserRequest(name, "pa$$word");
        RestAssured.given().port(port).contentType(ContentType.JSON).given().body(payload).post(Path.USERS).then()
                .statusCode(HttpStatus.SC_OK)
                .and().body("id", notNullValue());

        RestAssured.given().port(port).contentType(ContentType.JSON).given().body(payload).post(Path.USERS).then()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .and().body("message", is("Name " + name + " is already taken."));
    }

}

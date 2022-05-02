package com.asapp.backend.challenge.application.integration;

import com.asapp.backend.challenge.application.model.data.User;
import com.asapp.backend.challenge.application.model.requests.LoginRequest;
import com.asapp.backend.challenge.application.utils.Path;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class AuthTests extends IntegrationTests {

    @Test
    public void loginUser() {
        User user1 = createUser("newuser", "pa$$word");

        LoginRequest loginPayload = new LoginRequest("newuser", "pa$$word");
        RestAssured.given().port(port).contentType(ContentType.JSON).given().body(loginPayload).post(Path.LOGIN).then()
                .statusCode(HttpStatus.SC_OK)
                .and().body("id", notNullValue())
                .and().body("token", notNullValue());
    }

    @Test
    public void loginFail() {
        LoginRequest loginPayload = new LoginRequest("nonexistentUser", "pa$$word");
        RestAssured.given().port(port).contentType(ContentType.JSON).given().body(loginPayload).post(Path.LOGIN).then()
                .statusCode(HttpStatus.SC_UNAUTHORIZED)
                .and().body("message", is("Wrong User or Password"));
    }

}

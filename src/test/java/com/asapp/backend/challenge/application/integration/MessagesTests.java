package com.asapp.backend.challenge.application.integration;

import com.asapp.backend.challenge.application.model.data.User;
import com.asapp.backend.challenge.application.model.requests.CreateUserRequest;
import com.asapp.backend.challenge.application.model.requests.SendMessageRequest;
import com.asapp.backend.challenge.application.model.requests.messages.TextMessageContent;
import com.asapp.backend.challenge.application.utils.Path;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.notNullValue;

public class MessagesTests extends IntegrationTests {

    @Test
    public void sendTextMessage() {
        User user1 = createUser("User1", "pass1");
        User user2 = createUser("User2", "pass2");

        TextMessageContent textMessage = new TextMessageContent("Hello!");

        SendMessageRequest payload = new SendMessageRequest(user1.getId(), user2.getId(), textMessage);
        RestAssured.given().port(port).contentType(ContentType.JSON).given().body(payload).post(Path.MESSAGES).then()
                .statusCode(HttpStatus.SC_OK)
                .and().body("id", notNullValue())
                .and().body("timestamp", notNullValue());
    }
}

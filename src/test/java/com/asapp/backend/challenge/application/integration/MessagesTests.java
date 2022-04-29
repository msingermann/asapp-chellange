package com.asapp.backend.challenge.application.integration;

import com.asapp.backend.challenge.application.model.data.User;
import com.asapp.backend.challenge.application.model.requests.SendMessageRequest;
import com.asapp.backend.challenge.application.model.requests.messages.ImageMessageContent;
import com.asapp.backend.challenge.application.model.requests.messages.TextMessageContent;
import com.asapp.backend.challenge.application.model.requests.messages.VideoMessageContent;
import com.asapp.backend.challenge.application.utils.Path;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpHeaders;

import static org.hamcrest.Matchers.notNullValue;

public class MessagesTests extends IntegrationTests {

    @Test
    public void sendTextMessage() {
        User user1 = createUser("User1", "pass1");
        User user2 = createUser("User2", "pass2");

        //TODO get token from database (or add it manually)
        String token = "bearer 1234";

        TextMessageContent textMessage = new TextMessageContent("Hello!");

        SendMessageRequest payload = new SendMessageRequest(user1.getId(), user2.getId(), textMessage);
        RestAssured.given().port(port).contentType(ContentType.JSON).given().header(HttpHeaders.AUTHORIZATION, token).body(payload).post(Path.MESSAGES).then()
                .statusCode(HttpStatus.SC_OK)
                .and().body("id", notNullValue())
                .and().body("timestamp", notNullValue());
    }

    @Test
    public void sendImageMessage() {
        User user1 = createUser("User1", "pass1");
        User user2 = createUser("User2", "pass2");

        //TODO get token from database (or add it manually)
        String token = "bearer 1234";

        ImageMessageContent imageMessage = new ImageMessageContent("http://urlloca.com", 640, 480);

        SendMessageRequest payload = new SendMessageRequest(user1.getId(), user2.getId(), imageMessage);
        RestAssured.given().port(port).contentType(ContentType.JSON).given().header(HttpHeaders.AUTHORIZATION, token).body(payload).post(Path.MESSAGES).then()
                .statusCode(HttpStatus.SC_OK)
                .and().body("id", notNullValue())
                .and().body("timestamp", notNullValue());
    }

    @Test
    public void sendVideoMessage() {
        User user1 = createUser("User1", "pass1");
        User user2 = createUser("User2", "pass2");

        //TODO get token from database (or add it manually)
        String token = "bearer 1234";

        VideoMessageContent videoMessage = new VideoMessageContent("http://urlloca.com", "sourceloco");

        SendMessageRequest payload = new SendMessageRequest(user1.getId(), user2.getId(), videoMessage);
        RestAssured.given().port(port).contentType(ContentType.JSON).given().header(HttpHeaders.AUTHORIZATION, token).body(payload).post(Path.MESSAGES).then()
                .statusCode(HttpStatus.SC_OK)
                .and().body("id", notNullValue())
                .and().body("timestamp", notNullValue());
    }

}

package com.asapp.backend.challenge.application.integration;

import com.asapp.backend.challenge.application.model.data.Message;
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

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.hamcrest.Matchers.notNullValue;

public class MessagesTests extends IntegrationTests {

    @Test
    public void sendTextMessage() {
        User user1 = createUser("User1", "pass1");
        User user2 = createUser("User2", "pass2");

        String token = createToken(user1.getId());

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

        String token = createToken(user1.getId());

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

        String token = createToken(user1.getId());

        VideoMessageContent videoMessage = new VideoMessageContent("http://urlloca.com", "youtube");

        SendMessageRequest payload = new SendMessageRequest(user1.getId(), user2.getId(), videoMessage);
        RestAssured.given().port(port).contentType(ContentType.JSON).given().header(HttpHeaders.AUTHORIZATION, token).body(payload).post(Path.MESSAGES).then()
                .statusCode(HttpStatus.SC_OK)
                .and().body("id", notNullValue())
                .and().body("timestamp", notNullValue());
    }

    @Test
    public void getTextMessages() {
        User user1 = createUser("User1", "pass1");
        User user2 = createUser("User2", "pass2");

        List<Message> messages = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            messages.add(createTextMessage(user1.getId(), user2.getId()));
            messages.add(createImageMessage(user1.getId(), user2.getId()));
            messages.add(createVideoMessage(user1.getId(), user2.getId()));
        }

        String token = createToken(user1.getId());

        int limit = 5;

        String url = Path.MESSAGES + "?recipient=" + user2.getId() + "&start=" + messages.get(3).getId() + "&limit=" + limit;
        RestAssured.given().port(port).contentType(ContentType.JSON).given().header(HttpHeaders.AUTHORIZATION, token).get(url).then()
                .statusCode(HttpStatus.SC_OK)
                .body("$", hasSize(limit))
                //Ugly fix for issues in Matchers comparing Long https://github.com/rest-assured/rest-assured/issues/741
                .and().body("[0].id", is(Long.valueOf(messages.get(3).getId()).intValue()))
                .and().body("[1].id", is(Long.valueOf(messages.get(4).getId()).intValue()))
                .and().body("[2].id", is(Long.valueOf(messages.get(5).getId()).intValue()))
                .and().body("[3].id", is(Long.valueOf(messages.get(6).getId()).intValue()))
                .and().body("[4].id", is(Long.valueOf(messages.get(7).getId()).intValue()))
                //Validating order
                .and().body("[0].id", response -> lessThanOrEqualTo(response.path("[1].id")))
                .and().body("[1].id", response -> lessThanOrEqualTo(response.path("[2].id")))
                .and().body("[2].id", response -> lessThanOrEqualTo(response.path("[3].id")))
                .and().body("[3].id", response -> lessThanOrEqualTo(response.path("[4].id")));
    }

}
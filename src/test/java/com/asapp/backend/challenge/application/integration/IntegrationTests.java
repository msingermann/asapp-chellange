package com.asapp.backend.challenge.application.integration;

import com.asapp.backend.challenge.application.Application;
import com.asapp.backend.challenge.application.model.data.AuthToken;
import com.asapp.backend.challenge.application.model.data.Message;
import com.asapp.backend.challenge.application.model.data.User;
import com.asapp.backend.challenge.application.model.requests.CreateUserRequest;
import com.asapp.backend.challenge.application.repositories.AuthTokenRepository;
import com.asapp.backend.challenge.application.repositories.MessagesRepository;
import com.asapp.backend.challenge.application.repositories.UsersRepository;
import com.asapp.backend.challenge.application.utils.MapToJsonConverter;
import com.asapp.backend.challenge.application.utils.Path;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.AfterEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static org.hamcrest.Matchers.notNullValue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = {Application.class})
@ActiveProfiles("test")
public class IntegrationTests {
    @LocalServerPort
    protected int port;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private MessagesRepository messagesRepository;

    @Autowired
    private AuthTokenRepository authTokenRepository;

    @AfterEach
    public void cleanUp() {
        usersRepository.deleteAll();
        messagesRepository.deleteAll();
        authTokenRepository.deleteAll();
    }

    protected String createToken(long userId) {
        AuthToken token = new AuthToken(UUID.randomUUID().toString(), userId);
        return "bearer " + authTokenRepository.save(token).getToken();
    }
    protected User createUser(String name, String password) {
        User user = new User(name, password);
        usersRepository.save(user);
        return user;
    }
    protected Message createMessage(long sender, long recipient, String type, Map<String, Object> metadata) {
        Message message = new Message(sender, recipient, type, metadata);
        Message persistedMessage = messagesRepository.save(message);
        return persistedMessage;
    }

    protected Message createTextMessage(long sender, long recipient) {
        Map<String, Object> textMetadata = new HashMap<>();
        textMetadata.put("text", "hello!");
        return this.createMessage(sender, recipient, "TEXT", textMetadata);
    }

    protected Message createImageMessage(long sender, long recipient) {
        Map<String, Object> imageMetadata = new HashMap<>();
        imageMetadata.put("url", "http://urlloca.com");
        imageMetadata.put("width", 640);
        imageMetadata.put("height", 480);

        return this.createMessage(sender, recipient, "IMAGE", imageMetadata);
    }

    protected Message createVideoMessage(long sender, long recipient) {
        Map<String, Object> videoMetadata = new HashMap<>();
        videoMetadata.put("url", "http://urlloca.com");
        videoMetadata.put("source", "youtube");
        return this.createMessage(sender, recipient, "VIDEO", videoMetadata);
    }
}

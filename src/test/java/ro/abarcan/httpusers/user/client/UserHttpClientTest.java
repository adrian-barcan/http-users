package ro.abarcan.httpusers.user.client;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockserver.integration.ClientAndServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ro.abarcan.httpusers.user.config.TestConfig;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

@SpringBootTest(classes = {UserHttpClientTest.class, TestConfig.class})
class UserHttpClientTest {

    @Autowired
    private UserHttpClient userHttpClient;

    private ClientAndServer mockServer;

    @BeforeEach
    void startServer() {
        mockServer = ClientAndServer.startClientAndServer(2080);
    }

    @AfterEach
    void stopServer() {
        mockServer.stop();
    }

    @Test
    void getUsersReturnsExpectedUsers() throws IOException {
        var response = new String(Files.readAllBytes(Paths.get("src/test/resources/get-users.json")));

        mockServer.when(
                request().withMethod("GET")
                        .withPath("/users")
        ).respond(
                response()
                        .withBody(response)
                        .withHeader("Content-Type", "application/json")
        );

        var actual = userHttpClient.getUsers();
        assertEquals(2, actual.size());
    }

    @Test
    void getUserByIdReturnsExpectedUser() throws IOException {
        var response = new String(Files.readAllBytes(Paths.get("src/test/resources/get-users-id.json")));

        mockServer.when(
                request().withMethod("GET")
                        .withPath("/users/1")
        ).respond(
                response()
                        .withBody(response)
                        .withHeader("Content-Type", "application/json")
        );

        var actual = userHttpClient.getUserById(1);
        assertEquals(1, actual.get().id());
    }
}
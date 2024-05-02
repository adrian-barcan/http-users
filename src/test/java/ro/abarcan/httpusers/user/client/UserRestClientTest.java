package ro.abarcan.httpusers.user.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import ro.abarcan.httpusers.user.model.User;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@RestClientTest(UserRestClient.class)
class UserRestClientTest {

    @Autowired
    MockRestServiceServer server;

    @Autowired
    UserRestClient client;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void getUsersReturnsExpectedUsers() throws IOException {
        var response = new String(Files.readAllBytes(Paths.get("src/test/resources/get-users.json")));

        server.expect(requestTo("https://jsonplaceholder.typicode.com/users"))
                .andRespond(withSuccess(response, MediaType.APPLICATION_JSON));

        List<User> users = client.getUsers();
        assertEquals(2, users.size());
    }

    @Test
    void findByIdReturnsExpectedUser() throws IOException {
        var response = new String(Files.readAllBytes(Paths.get("src/test/resources/get-users-id.json")));

        server.expect(requestTo("https://jsonplaceholder.typicode.com/users/1"))
                .andRespond(withSuccess(response, MediaType.APPLICATION_JSON));

        var user = client.findById(1);
        assertEquals(1, user.get().id());
    }
}
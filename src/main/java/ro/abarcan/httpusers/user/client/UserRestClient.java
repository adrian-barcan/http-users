package ro.abarcan.httpusers.user.client;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import ro.abarcan.httpusers.user.model.User;

import java.util.List;
import java.util.Optional;

@Component
public class UserRestClient {

    private final RestClient restClient;

    public UserRestClient(RestClient.Builder restClientBuilder) {
        this.restClient = restClientBuilder
                .baseUrl("https://jsonplaceholder.typicode.com")
                .build();
    }

    public List<User> getUsers() {
        return restClient.get()
                .uri("/users")
                .retrieve()
                .body(new ParameterizedTypeReference<>() {
                });
    }

    public Optional<User> findById(int id) {
        return Optional.ofNullable(restClient.get()
                .uri("/users/{id}", id)
                .retrieve()
                .body(User.class));
    }

}


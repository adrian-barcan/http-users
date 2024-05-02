package ro.abarcan.httpusers.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.abarcan.httpusers.user.client.UserHttpClient;
import ro.abarcan.httpusers.user.model.User;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserHttpClient userRestClient;

    public UserController(UserHttpClient userRestClient) {
        this.userRestClient = userRestClient;
    }

    @GetMapping
    public List<User> getUsers() {
        return userRestClient.getUsers();
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Integer id) {
        return userRestClient.getUserById(id);
    }
}

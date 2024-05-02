package ro.abarcan.httpusers.user.client;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import ro.abarcan.httpusers.user.model.User;

import java.util.List;
import java.util.Optional;

public interface UserHttpClient {

    @GetExchange("/users")
    List<User> getUsers();

    @GetExchange("/users/{id}")
    Optional<User> getUserById(@PathVariable Integer id);
}

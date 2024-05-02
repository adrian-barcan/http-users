package ro.abarcan.httpusers.user.config;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;
import ro.abarcan.httpusers.user.client.UserHttpClient;

@TestConfiguration
public class TestConfig {

    @Bean
    @Primary
    UserHttpClient userHttpClient() {
        var client = RestClient.builder()
                .baseUrl("http://localhost:2080")
                .build();
        var httpServiceProxyFactory = HttpServiceProxyFactory.builderFor(RestClientAdapter.create(client))
                .build();

        return httpServiceProxyFactory.createClient(UserHttpClient.class);
    }
}

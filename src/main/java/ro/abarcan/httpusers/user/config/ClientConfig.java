package ro.abarcan.httpusers.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;
import ro.abarcan.httpusers.user.client.UserHttpClient;

@Configuration
public class ClientConfig {

    @Bean
    public UserHttpClient userHttpClient(RestClient client) {

        var httpServiceProxyFactory = HttpServiceProxyFactory.builderFor(RestClientAdapter.create(client))
                .build();

        return httpServiceProxyFactory.createClient(UserHttpClient.class);
    }

    @Bean
    public RestClient getRestClient() {
        return RestClient.builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .build();
    }
}

package tech.fivedhub.companyservice.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import tech.fivedhub.companyservice.dto.UserDto;

import java.util.List;
import java.util.Map;

@Slf4j
@Component
public class UserClient {

    private final WebClient webClient;

    public UserClient(@Value("${application.user-server-url}") String userServerUrl) {
        this.webClient = WebClient.create(userServerUrl);
    }

    public List<UserDto> getEmployeesList(List<Long> ids) {
        Map<String, Object> parameters = Map.of(
                "ids", ids
        );
        String path = "/api/users?ids={ids}";
        return webClient
                .get()
                .uri(path, parameters)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<UserDto>>() {})
                .doOnError(error -> log.error("User server is not responding! ErrorMessage: {}", error.getMessage()))
                .block();
    }
}

package com.scoutapp.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import java.util.Map;

@Component
public class SportsDbClient {

    private final RestClient restClient;

    public SportsDbClient(@Value("${thesportsdb.url}") String baseUrl,
                          @Value("${thesportsdb.key}") String apiKey) {
        this.restClient = RestClient.builder()
                .baseUrl(baseUrl + apiKey)
                .build();
    }

    public Map<String, Object> searchPlayer(String name) {
        return restClient.get()
                .uri("/searchplayers.php?p={name}", name)
                .retrieve()
                .body(Map.class);
    }
}

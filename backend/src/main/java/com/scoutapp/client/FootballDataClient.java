package com.scoutapp.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import java.util.Map;

@Component
public class FootballDataClient {

    private final RestClient restClient;

    public FootballDataClient(@Value("${football-data.url}") String baseUrl,
                              @Value("${football-data.key}") String apiKey) {
        this.restClient = RestClient.builder()
                .baseUrl(baseUrl)
                .defaultHeader("X-Auth-Token", apiKey)
                .build();
    }

    public Map<String, Object> getTopScorers(String competitionCode) {
        return restClient.get()
                .uri("/competitions/{code}/scorers", competitionCode)
                .retrieve()
                .body(Map.class);
    }
}

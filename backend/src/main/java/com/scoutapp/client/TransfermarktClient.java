package com.scoutapp.client;

import com.scoutapp.dto.transfermarkt.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.RestClient;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Component
@Slf4j
public class TransfermarktClient {

    private final RestClient restClient;
    private final RestTemplate restTemplate = new RestTemplate();
    private final String officialTmUrl = "https://tmapi.transfermarkt.technology";

    public TransfermarktClient(@Value("${transfermarkt.url:https://transfermarkt-api.fly.dev/}") String baseUrl) {
        // Ensure baseUrl doesn't end with a slash if paths start with a slash
        String normalizedBaseUrl = baseUrl.endsWith("/") ? baseUrl.substring(0, baseUrl.length() - 1) : baseUrl;
        this.restClient = RestClient.builder()
                .baseUrl(normalizedBaseUrl)
                .build();
    }

    /**
     * Search for players
     */
    public List<TransfermarktPlayerDto> searchPlayers(String query) {
        log.info("[TRANSFERMARKT REQUEST] GET /players/search/{}", query);
        try {
            TransfermarktSearchResponseDto response = restClient.get()
                    .uri("/players/search/{query}", query)
                    .retrieve()
                    .body(TransfermarktSearchResponseDto.class);
            log.info("[TRANSFERMARKT RESPONSE] Found {} players for query '{}'", 
                (response != null && response.getResults() != null) ? response.getResults().size() : 0, query);
            return response != null ? response.getResults() : List.of();
        } catch (Exception e) {
            log.error("[TRANSFERMARKT ERROR] searchPlayers: {}", e.getMessage());
            return List.of();
        }
    }

    public TransfermarktProfileDto getPlayerProfile(String id) {
        log.info("[TRANSFERMARKT REQUEST] GET /players/{}/profile", id);
        try {
            TransfermarktProfileDto response = restClient.get()
                    .uri("/players/{id}/profile", id)
                    .retrieve()
                    .body(TransfermarktProfileDto.class);
            log.info("[TRANSFERMARKT RESPONSE] Successfully fetched profile for ID {}", id);
            return response;
        } catch (Exception e) {
            log.error("[TRANSFERMARKT ERROR] getPlayerProfile for {}: {}", id, e.getMessage());
            return null;
        }
    }

    /**
     * Get market value
     */
    public Map<String, Object> getMarketValue(String id) {
        try {
            return restClient.get()
                    .uri("/players/{id}/market_value", id)
                    .retrieve()
                    .body(Map.class);
        } catch (Exception e) {
            log.error("Error fetching market value for id {}: {}", id, e.getMessage());
            return Map.of();
        }
    }

    /**
     * Get statistics
     */
    public Map<String, Object> getPlayerStats(String id) {
        try {
            return restClient.get()
                    .uri("/players/{id}/stats", id)
                    .retrieve()
                    .body(Map.class);
        } catch (Exception e) {
            log.error("Error fetching stats for id {}: {}", id, e.getMessage());
            return Map.of();
        }
    }

    /**
     * Get transfers
     */
    public Map<String, Object> getTransfers(String id) {
        try {
            return restClient.get()
                    .uri("/players/{id}/transfers", id)
                    .retrieve()
                    .body(Map.class);
        } catch (Exception e) {
            log.error("Error fetching transfers for id {}: {}", id, e.getMessage());
            return Map.of();
        }
    }

    /**
     * Get injuries
     */
    public Map<String, Object> getInjuries(String id) {
        try {
            return restClient.get()
                    .uri("/players/{id}/injuries", id)
                    .retrieve()
                    .body(Map.class);
        } catch (Exception e) {
            log.error("Error fetching injuries for id {}: {}", id, e.getMessage());
            return Map.of();
        }
    }

    /**
     * Get clubs in a competition
     */
    public List<TransfermarktCompetitionClubsDto.ClubDto> getClubs(String competitionId, String season) {
        try {
            TransfermarktCompetitionClubsDto response = restClient.get()
                    .uri("/competitions/{id}/clubs?season_id={season}", competitionId, season)
                    .retrieve()
                    .body(TransfermarktCompetitionClubsDto.class);
            return response != null ? response.getClubs() : List.of();
        } catch (Exception e) {
            log.error("Error fetching clubs for competition {} season {}: {}", competitionId, season, e.getMessage());
            return List.of();
        }
    }

    /**
     * Get players in a club
     */
    public List<TransfermarktPlayerDto> getClubPlayers(String clubId, String season) {
        try {
            TransfermarktClubPlayersDto response = restClient.get()
                    .uri("/clubs/{id}/players?season_id={season}", clubId, season)
                    .retrieve()
                    .body(TransfermarktClubPlayersDto.class);
            return response != null ? response.getPlayers() : List.of();
        } catch (Exception e) {
            log.error("Error fetching players for club {} season {}: {}", clubId, season, e.getMessage());
            return List.of();
        }
    }

    /**
     * Fetch granular performance data directly from TM Technology API with official headers
     */
    public TMPerformanceResponse fetchPlayerPerformanceGame(String tmId) {
        String url = officialTmUrl + "/player/" + tmId + "/performance-game";
        log.info("[TRANSFERMARKT REQUEST] GET {}", url);

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:152.0) Gecko/20100101 Firefox/152.0");
        headers.set("Referer", "https://www.transfermarkt.it/");
        headers.set("Origin", "https://www.transfermarkt.it");
        headers.set("Accept-Language", "it,en-US;q=0.9,en;q=0.8");

        HttpEntity<Void> entity = new HttpEntity<>(headers);
        
        try {
            return restTemplate.exchange(url, HttpMethod.GET, entity, TMPerformanceResponse.class).getBody();
        } catch (Exception e) {
            log.error("[TRANSFERMARKT ERROR] fetchPlayerPerformanceGame for {}: {}", tmId, e.getMessage());
            return null;
        }
    }
}

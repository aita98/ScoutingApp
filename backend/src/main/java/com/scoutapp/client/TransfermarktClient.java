package com.scoutapp.client;

import com.scoutapp.dto.transfermarkt.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import java.util.List;
import java.util.Map;

@Component
@Slf4j
public class TransfermarktClient {

    private final RestClient restClient;

    public TransfermarktClient(@Value("${transfermarkt.url:https://transfermarkt-api.fly.dev/}") String baseUrl) {
        this.restClient = RestClient.builder()
                .baseUrl(baseUrl)
                .build();
    }

    /**
     * Search for players
     */
    public List<TransfermarktPlayerDto> searchPlayers(String query) {
        try {
            TransfermarktSearchResponseDto response = restClient.get()
                    .uri("/players/search/{query}", query)
                    .retrieve()
                    .body(TransfermarktSearchResponseDto.class);
            return response != null ? response.getResults() : List.of();
        } catch (Exception e) {
            log.error("Error searching players for query {}: {}", query, e.getMessage());
            return List.of();
        }
    }

    /**
     * Get player profile (Anagrafica + Stats)
     */
    public TransfermarktProfileDto getPlayerProfile(String id) {
        try {
            return restClient.get()
                    .uri("/players/{id}/profile", id)
                    .retrieve()
                    .body(TransfermarktProfileDto.class);
        } catch (Exception e) {
            log.error("Error fetching profile for id {}: {}", id, e.getMessage());
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
}

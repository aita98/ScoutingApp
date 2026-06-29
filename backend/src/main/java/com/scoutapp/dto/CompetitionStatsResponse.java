package com.scoutapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompetitionStatsResponse {
    private String player;
    private Integer season;
    private Map<String, CompetitionData> competitions;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CompetitionData {
        private String competitionName;
        private String competitionIconUrl;
        private List<GameStats> games;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class GameStats {
        private String gameId;
        private Integer minutes;
        private Boolean isStarting;
        private Integer goals;
        private Integer assists;
        private Integer yellow;
        private Integer red;
        private String participationState;
    }
}

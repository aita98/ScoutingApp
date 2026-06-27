package com.scoutapp.dto.transfermarkt;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TMPerformanceResponse {
    private TMData data;
    private List<TMMatch> performance; // Fallback for root list

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class TMData {
        private String playerId;
        private List<TMMatch> performance;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class TMMatch {
        private GameInformation gameInformation;
        private Statistics statistics;
        private String participationState;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class GameInformation {
        private String gameId;
        private String competitionId;
        private Season season;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Season {
        @JsonProperty("nonCyclicalName")
        private String nonCyclicalName;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Statistics {
        private GeneralStatistics generalStatistics;
        private GoalStatistics goalStatistics;
        private PlayingTimeStatistics playingTimeStatistics;
        private CardStatistics cardStatistics;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class GeneralStatistics {
        private String participationState;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class GoalStatistics {
        private Integer goalsScoredTotalOfficial;
        private Integer assistsOfficial;
        private Integer scoringAttempts;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PlayingTimeStatistics {
        private Boolean isStarting;
        private Integer playedMinutes;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class CardStatistics {
        private Integer yellowCardGross;
        private Integer redCardsRescinded;
        @JsonProperty("yellowRedCard")
        private Object yellowRedCard;
    }
}

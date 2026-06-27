package com.scoutapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlayerResponseDto {
    private Long id;
    private String name;
    private String club;
    private String league;
    private Integer age;
    private Double marketValue;
    private String marketValueDisplay;
    private Double talentScore;
    private Double hiddenGemScore;
    private String position;
    private String photoUrl;
    private String transfermarktId;
    
    // New status flags
    private Boolean isConsigliato;
    private Boolean isHiddenGem;
    
    // Advanced Stats for Radar
    private Integer goals;
    private Integer assists;
    private Double xG;
    private Double xA;
    private Integer keyPasses;
    private Integer progressivePasses;
    private Integer progressiveCarries;

    private List<SeasonStatsDto> statistics;
    private List<RecentMatchDto> recentMatches;
    private RadarDataDto radar;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SeasonStatsDto {
        private Integer appearances;
        private Integer goals;
        private Integer assists;
        private Integer yellowCards;
        private Integer redCards;
        private Integer minutes;
    }
}

package com.scoutapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ComparisonDto {
    private PlayerSummary playerA;
    private PlayerSummary playerB;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PlayerSummary {
        private String name;
        private String club;
        private Double goalsPer90;
        private Double assistsPer90;
        private Integer minutesPlayed;
        private Double starterPercentage;
        private Double talentScore;
        private Double hiddenGemScore;
    }
}

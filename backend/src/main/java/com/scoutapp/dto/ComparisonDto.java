package com.scoutapp.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ComparisonDto {
    private PlayerSummary playerA;
    private PlayerSummary playerB;

    @Data
    @Builder
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

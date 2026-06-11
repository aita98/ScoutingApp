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
    private Integer age;
    private Double marketValue;
    private Double talentScore;
    private Double hiddenGemScore;
    private String position;
    private String photoUrl;
    private List<SeasonStatsDto> statistics;

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

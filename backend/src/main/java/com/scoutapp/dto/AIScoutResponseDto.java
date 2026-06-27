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
public class AIScoutResponseDto {
    private String scoutingReport;
    private List<SimilarPlayerDto> similarPlayers;
    private Integer similarityScore;
    private String recommendations;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SimilarPlayerDto {
        private Long id;
        private String name;
        private String club;
        private Integer similarityScore;
    }
}

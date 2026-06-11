package com.scoutapp.dto;

import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@Builder
public class AIScoutResponseDto {
    private String scoutingReport;
    private List<SimilarPlayerDto> similarPlayers;
    private Integer similarityScore;
    private String recommendations;

    @Data
    @Builder
    public static class SimilarPlayerDto {
        private Long id;
        private String name;
        private String club;
        private Integer similarityScore;
    }
}

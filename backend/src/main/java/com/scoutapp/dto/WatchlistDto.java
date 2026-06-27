package com.scoutapp.dto;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Builder
public class WatchlistDto {
    private Long id;
    private Long playerId;
    private String playerName;
    private String club;
    private Double talentScore;
    private LocalDateTime dateAdded;
}

package com.scoutapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WatchlistDto {
    private Long id;
    private Long playerId;
    private String playerName;
    private String club;
    private Double talentScore;
    private LocalDateTime dateAdded;
}

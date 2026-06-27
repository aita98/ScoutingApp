package com.scoutapp.dto;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Builder
public class ScoutFeedDto {
    private Long id;
    private String playerNames;
    private String eventType;
    private String description;
    private LocalDateTime createdAt;
    private Long playerId;
}

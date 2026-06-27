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
public class ScoutFeedDto {
    private Long id;
    private String playerNames;
    private String eventType;
    private String description;
    private LocalDateTime createdAt;
    private Long playerId;
    private String photoUrl;
}

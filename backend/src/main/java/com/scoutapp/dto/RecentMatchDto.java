package com.scoutapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecentMatchDto {
    private Integer goals;
    private Integer assists;
    private Integer minutes;
    private Boolean isStarting;
}

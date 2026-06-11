package com.scoutapp.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RadarDataDto {
    private Integer pace;
    private Integer shooting;
    private Integer passing;
    private Integer dribbling;
    private Integer physical;
    private Integer intelligence;
}

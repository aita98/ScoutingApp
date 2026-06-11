package com.scoutapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeagueDto {
    private Long id;
    private String name;
    private String country;
    private String logoUrl;
}

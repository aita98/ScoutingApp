package com.scoutapp.dto.transfermarkt;

import lombok.Data;
import java.util.List;
import java.util.Map;

@Data
public class TransfermarktCompetitionClubsDto {
    private List<ClubDto> clubs;

    @Data
    public static class ClubDto {
        private String id;
        private String name;
        private String image;
    }
}

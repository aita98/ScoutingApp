package com.scoutapp.dto.transfermarkt;

import lombok.Data;
import java.util.List;

@Data
public class TransfermarktClubPlayersDto {
    private String id;
    private String name;
    private List<TransfermarktPlayerDto> players;
}

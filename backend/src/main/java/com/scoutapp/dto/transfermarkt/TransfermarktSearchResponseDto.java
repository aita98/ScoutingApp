package com.scoutapp.dto.transfermarkt;

import lombok.Data;
import java.util.List;

@Data
public class TransfermarktSearchResponseDto {
    private List<TransfermarktPlayerDto> results;
}

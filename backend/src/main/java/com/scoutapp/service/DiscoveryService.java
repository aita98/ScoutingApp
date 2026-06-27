package com.scoutapp.service;

import com.scoutapp.client.TransfermarktClient;
import com.scoutapp.dto.transfermarkt.TransfermarktPlayerDto;
import com.scoutapp.entity.Player;
import com.scoutapp.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class DiscoveryService {

    private final PlayerRepository playerRepository;
    private final TransfermarktClient transfermarktClient;
    private final SofascoreService sofascoreService;

    @Transactional
    public void autoLinkPlayer(Player player) {
        log.info("Auto-linking IDs for player: {}", player.getName());
        
        // 1. Link Transfermarkt ID if missing
        if (player.getTransfermarktId() == null) {
            discoverTransfermarktId(player);
        }

        // 2. Link Sofascore ID if missing
        if (player.getSofascoreId() == null) {
            Long ssId = sofascoreService.searchPlayerId(player.getName(), player.getClub());
            if (ssId != null) {
                player.setSofascoreId(ssId);
            }
        }

        playerRepository.save(player);
    }

    private void discoverTransfermarktId(Player player) {
        log.info("Searching Transfermarkt ID for: {}", player.getName());
        List<TransfermarktPlayerDto> results = transfermarktClient.searchPlayers(player.getName());
        
        for (TransfermarktPlayerDto result : results) {
            if (isTmMatch(player, result)) {
                log.info("Found Transfermarkt ID for {}: {}", player.getName(), result.getId());
                player.setTransfermarktId(result.getId());
                if (player.getAge() == null) player.setAge(result.getAge());
                if (player.getPosition() == null) player.setPosition(result.getPosition());
                break;
            }
        }
    }

    private boolean isTmMatch(Player player, TransfermarktPlayerDto tm) {
        String n1 = player.getName().toLowerCase();
        String n2 = tm.getName().toLowerCase();
        boolean nameMatch = n1.contains(n2) || n2.contains(n1);

        String c1 = player.getClub() != null ? player.getClub().toLowerCase() : "";
        String c2 = tm.getClubName() != null ? tm.getClubName().toLowerCase() : "";
        boolean clubMatch = c1.isEmpty() || c2.isEmpty() || c1.contains(c2) || c2.contains(c1);

        return nameMatch && clubMatch;
    }
}

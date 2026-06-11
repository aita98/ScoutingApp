package com.scoutapp.controller;

import com.scoutapp.dto.ComparisonDto;
import com.scoutapp.dto.RadarDataDto;
import com.scoutapp.entity.Player;
import com.scoutapp.repository.PlayerRepository;
import com.scoutapp.repository.TransfermarktRepository;
import com.scoutapp.service.ScoutingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@RestController
@RequestMapping("/api/players")
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class PlayerController {

    private final PlayerRepository playerRepository;
    private final ScoutingService scoutingService;
    private final TransfermarktRepository transfermarktRepository;

    @GetMapping("/recommended")
    public List<Player> getRecommended() {
        return playerRepository.findRecommendedProspects();
    }

    @GetMapping("/hidden-gems")
    public List<Player> getHiddenGems() {
        return playerRepository.findHiddenGems();
    }

    @GetMapping("/top-prospects")
    public List<Player> getTopProspects() {
        return playerRepository.findTop10ByOrderByTalentScoreDesc();
    }

    @GetMapping("/{id}")
    public Player getPlayer(@PathVariable Long id) {
        log.info("Fetching player with ID: {}", id);
        Player player = playerRepository.findById(id).orElse(null);
        
        if (player == null) {
            player = playerRepository.findByApiFootballId(id.intValue()).orElse(null);
        }
        
        if (player == null) {
            log.warn("Player NOT FOUND in database for ID: {}", id);
            return null;
        }
        
        return player;
    }

    @GetMapping("/compare")
    public ComparisonDto compare(@RequestParam Long playerA, @RequestParam Long playerB) {
        return scoutingService.comparePlayers(playerA, playerB);
    }

    @GetMapping("/{id}/radar")
    public RadarDataDto getRadarData(@PathVariable Long id) {
        log.info("Fetching radar data for player ID: {}", id);
        try {
            return scoutingService.generateRadarData(id);
        } catch (Exception e) {
            log.warn("Radar data not found for ID {}: {}", id, e.getMessage());
            return RadarDataDto.builder()
                    .pace(50).shooting(50).passing(50)
                    .dribbling(50).physical(50).intelligence(50)
                    .build();
        }
    }

    @GetMapping("/club/{clubName}")
    public List<Player> getPlayersByClub(@PathVariable String clubName) {
        return playerRepository.findAll().stream()
                .filter(p -> p.getClub() != null && p.getClub().equalsIgnoreCase(clubName))
                .collect(java.util.stream.Collectors.toList());
    }

    @GetMapping("/search")
    public List<Player> search(@RequestParam String query) {
        return transfermarktRepository.searchAndSavePlayers(query);
    }

    @PostMapping("/{id}/sync-tm")
    public Player syncWithTransfermarkt(@PathVariable Long id, @RequestParam(required = false) String tmId) {
        return transfermarktRepository.syncPlayerProfile(id, tmId);
    }
}

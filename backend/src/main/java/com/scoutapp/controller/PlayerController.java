package com.scoutapp.controller;

import com.scoutapp.dto.PlayerResponseDto;
import com.scoutapp.dto.RadarDataDto;
import com.scoutapp.entity.Player;
import com.scoutapp.repository.PlayerRepository;
import com.scoutapp.repository.TransfermarktRepository;
import com.scoutapp.service.DiscoveryService;
import com.scoutapp.service.ScoutingService;
import com.scoutapp.service.TransfermarktSyncService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import com.scoutapp.dto.RecentMatchDto;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api/players")
@RequiredArgsConstructor
@Slf4j
public class PlayerController {

    private final PlayerRepository playerRepository;
    private final ScoutingService scoutingService;
    private final TransfermarktRepository transfermarktRepository;
    private final DiscoveryService discoveryService;
    private final TransfermarktSyncService transfermarktSyncService;
    private final ObjectMapper objectMapper;

    @GetMapping("/otw")
    @Transactional(readOnly = true)
    public List<PlayerResponseDto> getOTW() {
        return playerRepository.findOneToWatch().stream().map(this::mapToDto).collect(java.util.stream.Collectors.toList());
    }

    @GetMapping("/hidden-gems")
    @Transactional(readOnly = true)
    public List<PlayerResponseDto> getHiddenGems() {
        return playerRepository.findHiddenGems().stream().map(this::mapToDto).collect(java.util.stream.Collectors.toList());
    }

    @GetMapping("/top-prospects")
    @Transactional(readOnly = true)
    public List<PlayerResponseDto> getTopProspects() {
        return playerRepository.findTop10ByOrderByTalentScoreDesc().stream().map(this::mapToDto).collect(java.util.stream.Collectors.toList());
    }

    @GetMapping("/{id}")
    @Transactional
    public PlayerResponseDto getPlayer(@PathVariable Long id) {
        log.info("[GET PLAYER] Requested ID: {}", id);
        
        Player player = playerRepository.findById(id).orElse(null);
        if (player == null) {
            player = playerRepository.findByTransfermarktId(id.toString()).orElse(null);
        }
        
        // If not found, try to import from TM first if ID looks like TM ID
        if (player == null && id > 1000) {
            log.info("[GET PLAYER] Not found in DB, attempting to import by TM ID: {}", id);
            try {
                player = transfermarktRepository.syncPlayerProfile(null, id.toString());
            } catch (Exception e) {
                log.warn("[GET PLAYER] TM import failed for ID: {}", id);
            }
        }
        
        if (player == null) {
            log.warn("[GET PLAYER] NOT FOUND for ID: {}", id);
            return null;
        }

        // 2. RECUPERO E AGGREGAZIONE DELLE STATISTICHE (Se non presenti o obsolete)
        if (player.getTransfermarktId() != null) {
            boolean needsSync = player.getStatistics() == null || player.getStatistics().isEmpty() || 
                                player.getLastUpdated() == null || 
                                player.getLastUpdated().isBefore(java.time.LocalDateTime.now().minusHours(12));
            
            if (needsSync) {
                try {
                    transfermarktSyncService.syncAndAggregateStats(player.getId(), player.getTransfermarktId(), "25/26");
                } catch (Exception e) {
                    log.error("[SYNC ERROR] Failed to sync stats for player {}: {}", player.getName(), e.getMessage());
                }
            } else {
                log.info("[CACHE] Using stored stats for player {}", player.getName());
            }
        }

        // Ensure discovery is complete
        try {
            discoveryService.discoverAndLink(player);
        } catch (Exception e) {
            log.error("[DISCOVERY ERROR] {}", e.getMessage());
        }

        return mapToDto(player);
    }

    @GetMapping("/search")
    @Transactional
    public List<PlayerResponseDto> search(@RequestParam String query) {
        log.info("[SEARCH] Global search for: {}", query);
        List<Player> players = transfermarktRepository.searchAndSavePlayers(query);
        return players.stream().map(this::mapToDto).collect(java.util.stream.Collectors.toList());
    }

    private PlayerResponseDto mapToDto(Player p) {
        List<PlayerResponseDto.SeasonStatsDto> stats = new ArrayList<>();
        
        if (p.getStatistics() != null && !p.getStatistics().isEmpty()) {
            p.getStatistics().forEach(s -> stats.add(PlayerResponseDto.SeasonStatsDto.builder()
                    .appearances(s.getAppearances())
                    .goals(s.getGoals())
                    .assists(s.getAssists())
                    .minutes(s.getMinutes())
                    .yellowCards(s.getYellowCards())
                    .redCards(s.getRedCards())
                    .build()));
        }

        // Recent Matches (Form)
        List<RecentMatchDto> recentMatches = null;
        if (p.getRecentPerformanceJson() != null) {
            try {
                recentMatches = objectMapper.readValue(p.getRecentPerformanceJson(), new TypeReference<List<RecentMatchDto>>() {});
            } catch (Exception e) {
                log.error("[DTO] Error parsing recent matches for {}: {}", p.getName(), e.getMessage());
            }
        }

        // Radar Data
        RadarDataDto radar = null;
        try {
            radar = scoutingService.generateRadarData(p.getId());
        } catch (Exception e) {}

        return PlayerResponseDto.builder()
                .id(p.getId())
                .name(p.getName())
                .club(p.getClub())
                .league(p.getLeague())
                .age(p.getAge())
                .marketValue(p.getMarketValue())
                .marketValueDisplay(formatMarketValue(p.getMarketValue()))
                .position(p.getPosition())
                .photoUrl(p.getPhotoUrl())
                .talentScore(p.getTalentScore())
                .hiddenGemScore(p.getHiddenGemScore())
                .isConsigliato(p.getIsConsigliato())
                .isHiddenGem(p.getIsHiddenGem())
                .goals(p.getGoals())
                .assists(p.getAssists())
                .xG(p.getXg())
                .xA(p.getXa())
                .keyPasses(p.getKeyPasses())
                .progressivePasses(p.getProgressivePasses())
                .progressiveCarries(p.getProgressiveCarries())
                .transfermarktId(p.getTransfermarktId())
                .isConsigliato(p.getIsConsigliato())
                .isHiddenGem(p.getIsHiddenGem())
                .statistics(stats)
                .recentMatches(recentMatches)
                .radar(radar)
                .build();
    }

    private String formatMarketValue(Double value) {
        if (value == null || value == 0.0) return "N/A";
        if (value >= 1_000_000) {
            return String.format("%.1fM€", value / 1_000_000.0);
        } else if (value >= 1_000) {
            return String.format("%.0fK€", value / 1_000.0);
        }
        return String.format("%.0f€", value);
    }
}

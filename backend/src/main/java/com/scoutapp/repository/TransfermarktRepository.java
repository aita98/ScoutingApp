package com.scoutapp.repository;

import com.scoutapp.client.TransfermarktClient;
import com.scoutapp.dto.transfermarkt.*;
import com.scoutapp.entity.Player;
import com.scoutapp.entity.PlayerStats;
import com.scoutapp.service.DiscoveryService;
import com.scoutapp.service.ScoutingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
@Slf4j
public class TransfermarktRepository {

    private final TransfermarktClient transfermarktClient;
    private final PlayerRepository playerRepository;
    private final ScoutingService scoutingService;
    private final DiscoveryService discoveryService;

    @Transactional
    public Player mapAndSavePlayer(TransfermarktPlayerDto dto) {
        String tmId = dto.getId() != null ? dto.getId().trim() : null;
        if (tmId == null) return null;

        return playerRepository.findByTransfermarktId(tmId)
                .map(existing -> updateExistingPlayer(existing, dto))
                .orElseGet(() -> createNewPlayer(dto));
    }

    private Player createNewPlayer(TransfermarktPlayerDto dto) {
        String tmId = dto.getId().trim();
        String photoUrl = dto.getImageUrl();
        if (photoUrl == null || photoUrl.isEmpty()) {
            photoUrl = "https://www.transfermarkt.com/images/portrait/header/" + tmId + ".jpg";
        }

        Player player = Player.builder()
                .transfermarktId(tmId)
                .name(dto.getName())
                .club(dto.getClubName())
                .age(dto.getAge())
                .position(dto.getPosition())
                .photoUrl(photoUrl)
                .marketValue(parseMarketValue(dto.getMarketValueDisplay()))
                .talentScore(0.0)
                .hiddenGemScore(0.0)
                .lastUpdated(LocalDateTime.now())
                .build();
        
        try {
            return playerRepository.save(player);
        } catch (Exception e) {
            // Last resort fallback if findByTransfermarktId failed due to concurrency
            return playerRepository.findByTransfermarktId(tmId).orElse(null);
        }
    }

    private Player updateExistingPlayer(Player player, TransfermarktPlayerDto dto) {
        player.setName(dto.getName());
        player.setClub(dto.getClubName());
        if (dto.getAge() != null) player.setAge(dto.getAge());
        if (dto.getPosition() != null) player.setPosition(dto.getPosition());
        
        String photoUrl = dto.getImageUrl();
        if (photoUrl != null && !photoUrl.isEmpty()) {
            player.setPhotoUrl(photoUrl);
        }

        player.setMarketValue(parseMarketValue(dto.getMarketValueDisplay()));
        player.setLastUpdated(LocalDateTime.now());
        return playerRepository.save(player);
    }

    @Transactional
    public List<Player> searchAndSavePlayers(String query) {
        log.info("[SEARCH] Global search for: {}", query);
        List<TransfermarktPlayerDto> results = transfermarktClient.searchPlayers(query);
        return results.stream()
                .map(this::mapAndSavePlayer)
                .collect(Collectors.toList());
    }

    @Transactional
    public Player syncPlayerProfile(Long id, String tmId) {
        String cleanTmId = tmId != null ? tmId.trim() : null;
        log.info("[SYNC] Synchronizing profile. ID: {}, TM ID: {}", id, cleanTmId);
        
        Optional<Player> playerOpt = (id != null && id > 0) ? playerRepository.findById(id) : Optional.empty();
        
        if (playerOpt.isEmpty() && cleanTmId != null) {
            playerOpt = playerRepository.findByTransfermarktId(cleanTmId);
        }
        
        Player player = playerOpt.orElseGet(() -> {
            if (cleanTmId != null) {
                TransfermarktPlayerDto dto = new TransfermarktPlayerDto();
                dto.setId(cleanTmId);
                dto.setName("Pending Discovery");
                return createNewPlayer(dto);
            }
            throw new RuntimeException("Cannot sync player: No ID and no TM ID provided");
        });

        String targetTmId = (cleanTmId != null) ? cleanTmId : player.getTransfermarktId();
        if (targetTmId == null) return player;

        TransfermarktProfileDto profile = transfermarktClient.getPlayerProfile(targetTmId);
        if (profile == null) return player;

        player.setName(profile.getName());
        player.setAge(profile.getAge());
        
        if (profile.getImageUrl() != null && !profile.getImageUrl().isEmpty()) {
            player.setPhotoUrl(profile.getImageUrl());
        }
        
        player.setClub(profile.getClubName());
        player.setPosition(profile.getPositionName());
        player.setMarketValue(parseMarketValue(profile.getMarketValueDisplay()));
        player.setLastUpdated(LocalDateTime.now());

        discoveryService.discoverAndLink(player);

        if (profile.getStats() != null && !profile.getStats().isEmpty()) {
            updatePlayerStats(player, profile.getStats());
        }

        return playerRepository.save(player);
    }

    private void updatePlayerStats(Player player, List<Map<String, Object>> tmStats) {
        if (player.getStatistics() == null) player.setStatistics(new ArrayList<>());
        Map<String, Object> latest = tmStats.get(0);
        
        PlayerStats stats = PlayerStats.builder()
                .player(player)
                .season(2025)
                .appearances(parseSafeInt(latest.get("appearances")))
                .goals(parseSafeInt(latest.get("goals")))
                .assists(parseSafeInt(latest.get("assists")))
                .minutes(parseSafeInt(latest.get("minutesPlayed")))
                .yellowCards(parseSafeInt(latest.get("yellowCards")))
                .redCards(parseSafeInt(latest.get("redCards")))
                .starts(parseSafeInt(latest.get("appearances")))
                .build();

        player.getStatistics().removeIf(ps -> ps.getSeason().equals(stats.getSeason()));
        player.getStatistics().add(stats);
        
        player.setTalentScore(scoutingService.calculateTalentScore(player, stats));
        player.setHiddenGemScore(scoutingService.calculateHiddenGemScore(player, stats));
    }

    public List<TransfermarktCompetitionClubsDto.ClubDto> getCompetitionClubs(String competitionId, String season) {
        return transfermarktClient.getClubs(competitionId, season);
    }

    public List<TransfermarktPlayerDto> getClubPlayers(String clubId, String season) {
        return transfermarktClient.getClubPlayers(clubId, season);
    }

    private Integer parseSafeInt(Object val) {
        if (val == null) return 0;
        if (val instanceof Number) return ((Number) val).intValue();
        if (val instanceof String) {
             try { return Integer.parseInt(((String) val).replaceAll("[^0-9]", "")); } catch (Exception e) {}
        }
        return 0;
    }

    public Double parseMarketValue(String val) {
        if (val == null || val.isEmpty() || val.equals("N/A") || val.equals("null")) return 0.0;
        try {
            String clean = val.replace("€", "").trim().toLowerCase();
            double multiplier = 1.0;
            if (clean.endsWith("m") || clean.contains("mio")) {
                multiplier = 1_000_000.0;
                clean = clean.replace("m", "").replace("mio", "");
            } else if (clean.endsWith("k") || clean.contains("tous")) {
                multiplier = 1_000.0;
                clean = clean.replace("k", "").replace("tous", "");
            }
            String numericPart = clean.replaceAll("[^0-9.]", "");
            if (numericPart.isEmpty()) return 0.0;
            return Double.parseDouble(numericPart) * multiplier;
        } catch (Exception e) {
            log.error("Failed to parse market value: {}", val);
            return 0.0;
        }
    }
}

package com.scoutapp.repository;

import com.scoutapp.client.TransfermarktClient;
import com.scoutapp.dto.transfermarkt.*;
import com.scoutapp.entity.Player;
import com.scoutapp.entity.PlayerStats;
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

    @Transactional
    public List<Player> searchAndSavePlayers(String query) {
        List<TransfermarktPlayerDto> results = transfermarktClient.searchPlayers(query);
        return results.stream().map(this::mapAndSavePlayer).collect(Collectors.toList());
    }

    @Transactional
    public Player mapAndSavePlayer(TransfermarktPlayerDto dto) {
        Integer tmId = Integer.parseInt(dto.getId());
        return playerRepository.findByApiFootballId(tmId)
                .map(existing -> updateExistingPlayer(existing, dto))
                .orElseGet(() -> createNewPlayer(dto));
    }

    private Player createNewPlayer(TransfermarktPlayerDto dto) {
        Player player = Player.builder()
                .apiFootballId(Integer.parseInt(dto.getId()))
                .name(dto.getName())
                .club(dto.getClubName())
                .age(dto.getAge())
                .position(dto.getPosition())
                .photoUrl(dto.getImageUrl())
                .marketValue(parseMarketValue(dto.getMarketValueDisplay()))
                .talentScore(0.0)
                .hiddenGemScore(0.0)
                .lastUpdated(LocalDateTime.now())
                .build();
        return playerRepository.save(player);
    }

    private Player updateExistingPlayer(Player player, TransfermarktPlayerDto dto) {
        player.setName(dto.getName());
        player.setClub(dto.getClubName());
        if (dto.getAge() != null) player.setAge(dto.getAge());
        if (dto.getPosition() != null) player.setPosition(dto.getPosition());
        if (dto.getImageUrl() != null) player.setPhotoUrl(dto.getImageUrl());
        player.setMarketValue(parseMarketValue(dto.getMarketValueDisplay()));
        player.setLastUpdated(LocalDateTime.now());
        return playerRepository.save(player);
    }

    @Transactional
    public Player syncPlayerProfile(Long id, String tmId) {
        Player player = playerRepository.findById(id).orElseThrow();
        String targetTmId = (tmId != null) ? tmId : String.valueOf(player.getApiFootballId());

        TransfermarktProfileDto profile = transfermarktClient.getPlayerProfile(targetTmId);
        if (profile == null) return player;

        // Update basic info
        player.setName(profile.getName());
        player.setAge(profile.getAge());
        player.setPhotoUrl(profile.getImageUrl());
        player.setClub(profile.getClubName());
        player.setPosition(profile.getPosition());
        player.setMarketValue(parseMarketValue(profile.getMarketValueDisplay()));
        player.setLastUpdated(LocalDateTime.now());

        // Update stats
        if (profile.getStats() != null && !profile.getStats().isEmpty()) {
            updatePlayerStats(player, profile.getStats());
        }

        return playerRepository.save(player);
    }

    private void updatePlayerStats(Player player, List<TransfermarktProfileDto.TransfermarktStatDto> tmStats) {
        if (player.getStatistics() == null) player.setStatistics(new ArrayList<>());
        
        // Take the latest season (usually first in list or we could filter by season name)
        // For simplicity, we process the first one as current
        TransfermarktProfileDto.TransfermarktStatDto latest = tmStats.get(0);
        
        PlayerStats stats = PlayerStats.builder()
                .player(player)
                .season(2025) // Assuming current
                .appearances(latest.getAppearances() != null ? latest.getAppearances() : 0)
                .goals(latest.getGoals() != null ? latest.getGoals() : 0)
                .assists(latest.getAssists() != null ? latest.getAssists() : 0)
                .minutes(latest.getMinutesPlayed() != null ? latest.getMinutesPlayed() : 0)
                .yellowCards(latest.getYellowCards() != null ? latest.getYellowCards() : 0)
                .redCards(latest.getRedCards() != null ? latest.getRedCards() : 0)
                .starts(latest.getAppearances() != null ? latest.getAppearances() : 0)
                .build();

        player.getStatistics().removeIf(ps -> ps.getSeason().equals(stats.getSeason()));
        player.getStatistics().add(stats);
        
        // Recalculate scores
        player.setTalentScore(scoutingService.calculateTalentScore(player, stats));
        player.setHiddenGemScore(scoutingService.calculateHiddenGemScore(player, stats));
    }

    public Double parseMarketValue(String val) {
        if (val == null || val.isEmpty() || val.equals("N/A") || val.equals("null")) return 0.0;
        try {
            String clean = val.replace("€", "").trim().toLowerCase();
            double multiplier = 1.0;
            if (clean.endsWith("m")) {
                multiplier = 1_000_000.0;
                clean = clean.replace("m", "");
            } else if (clean.endsWith("k")) {
                multiplier = 1_000.0;
                clean = clean.replace("k", "");
            }
            clean = clean.replace(".", "").replace(",", ".");
            return Double.parseDouble(clean) * multiplier;
        } catch (Exception e) {
            log.error("Failed to parse market value: {}", val);
            return 0.0;
        }
    }

    public List<TransfermarktCompetitionClubsDto.ClubDto> getCompetitionClubs(String competitionId, String season) {
        return transfermarktClient.getClubs(competitionId, season);
    }

    public List<TransfermarktPlayerDto> getClubPlayers(String clubId, String season) {
        return transfermarktClient.getClubPlayers(clubId, season);
    }
}

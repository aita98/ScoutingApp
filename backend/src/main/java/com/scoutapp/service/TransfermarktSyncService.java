package com.scoutapp.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.scoutapp.client.TransfermarktClient;
import com.scoutapp.dto.RecentMatchDto;
import com.scoutapp.dto.transfermarkt.TMPerformanceResponse;
import com.scoutapp.entity.Player;
import com.scoutapp.entity.PlayerStats;
import com.scoutapp.repository.PlayerRepository;
import com.scoutapp.repository.PlayerStatsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransfermarktSyncService {

    private final TransfermarktClient transfermarktClient;
    private final PlayerRepository playerRepository;
    private final PlayerStatsRepository playerStatsRepository;
    private final ScoutingService scoutingService;
    private final ObjectMapper objectMapper;

    @Transactional
    public void syncAndAggregateStats(Long playerId, String tmId, String targetSeason) {
        Player player = playerRepository.findById(playerId).orElseThrow();
        
        // Check DB first to avoid redundant GET
        Integer seasonInt = 2025; 
        if (targetSeason.contains("/")) {
            try {
                String yearPart = targetSeason.split("/")[0];
                seasonInt = 2000 + Integer.parseInt(yearPart);
            } catch (Exception e) {}
        }
        final Integer finalSeason = seasonInt;
        
        Optional<PlayerStats> existingStats = playerStatsRepository.findByPlayerIdAndSeason(playerId, finalSeason);
        if (existingStats.isPresent() && player.getLastUpdated() != null && 
            player.getLastUpdated().isAfter(java.time.LocalDateTime.now().minusHours(12))) {
            log.info("[CACHE] Performance already synced for Player ID: {}", playerId);
            return;
        }

        log.info("[SYNC] Synchronizing and aggregating stats for Player ID: {}, TM ID: {}, Season: {}", playerId, tmId, targetSeason);
        
        TMPerformanceResponse response = transfermarktClient.fetchPlayerPerformanceGame(tmId);
        
        if (response == null) {
            log.warn("[SYNC] No performance response for TM ID: {}", tmId);
            return;
        }

        var performanceList = response.getData() != null ? response.getData().getPerformance() : response.getPerformance();
        if (performanceList == null || performanceList.isEmpty()) {
            log.warn("[SYNC] No performance data found for TM ID: {}", tmId);
            return;
        }

        int appearances = 0;
        int starts = 0;
        int goals = 0;
        int assists = 0;
        int yellowCards = 0;
        int redCards = 0;
        int minutes = 0;
        List<RecentMatchDto> recentMatches = new ArrayList<>();

        for (TMPerformanceResponse.TMMatch match : performanceList) {
            if (match.getGameInformation() == null || match.getGameInformation().getSeason() == null) continue;
            
            String gameSeason = match.getGameInformation().getSeason().getNonCyclicalName();
            
            // Collect for aggregate stats if season matches
            boolean isTargetSeason = targetSeason.equals(gameSeason);

            String participation = match.getParticipationState();
            if (participation == null && match.getStatistics() != null && match.getStatistics().getGeneralStatistics() != null) {
                participation = match.getStatistics().getGeneralStatistics().getParticipationState();
            }

            if ("played".equals(participation) || "in squad".equals(participation)) {
                if (isTargetSeason) appearances++;

                if (match.getStatistics() != null) {
                    var playingTime = match.getStatistics().getPlayingTimeStatistics();
                    int matchMins = 0;
                    boolean isStarting = false;
                    if (playingTime != null) {
                        if (Boolean.TRUE.equals(playingTime.getIsStarting())) {
                            if (isTargetSeason) starts++;
                            isStarting = true;
                        }
                        if (playingTime.getPlayedMinutes() != null) {
                            matchMins = playingTime.getPlayedMinutes();
                            if (isTargetSeason) minutes += matchMins;
                        }
                    }

                    var goalStats = match.getStatistics().getGoalStatistics();
                    int matchGoals = 0;
                    int matchAssists = 0;
                    if (goalStats != null) {
                        if (goalStats.getGoalsScoredTotalOfficial() != null) {
                            matchGoals = goalStats.getGoalsScoredTotalOfficial();
                            if (isTargetSeason) goals += matchGoals;
                        }
                        if (goalStats.getAssistsOfficial() != null) {
                            matchAssists = goalStats.getAssistsOfficial();
                            if (isTargetSeason) assists += matchAssists;
                        }
                    }

                    var cardStats = match.getStatistics().getCardStatistics();
                    if (cardStats != null) {
                        if (cardStats.getYellowCardGross() != null && cardStats.getYellowCardGross() > 0) {
                            if (isTargetSeason) yellowCards++;
                        }
                        if (cardStats.getYellowRedCard() != null && (cardStats.getRedCardsRescinded() == null || cardStats.getRedCardsRescinded() == 0)) {
                            if (isTargetSeason) redCards++;
                        }
                    }

                    // Add to recent matches (last 10 total, regardless of target season filter for form)
                    if (recentMatches.size() < 10 && "played".equals(participation)) {
                        recentMatches.add(RecentMatchDto.builder()
                                .goals(matchGoals)
                                .assists(matchAssists)
                                .minutes(matchMins)
                                .isStarting(isStarting)
                                .build());
                    }
                }
            }
        }

        // Removed duplicate declarations of player, seasonInt, and finalSeason
        PlayerStats stats = playerStatsRepository.findByPlayerIdAndSeason(playerId, finalSeason)
                .orElse(new PlayerStats());

        stats.setPlayer(player);
        stats.setSeason(finalSeason);
        stats.setAppearances(appearances);
        stats.setStarts(starts);
        stats.setGoals(goals);
        stats.setAssists(assists);
        stats.setYellowCards(yellowCards);
        stats.setRedCards(redCards);
        stats.setMinutes(minutes);
        
        // Calcolo percentuali
        stats.setAppearancePercentage(Math.min(100.0, ((double) appearances / 38.0) * 100.0));
        stats.setStarterPercentage(appearances > 0 ? ((double) starts / (double) appearances) * 100.0 : 0.0);

        playerStatsRepository.save(stats);
        
        if (player.getStatistics() == null) player.setStatistics(new ArrayList<>());
        player.getStatistics().removeIf(ps -> ps.getSeason().equals(finalSeason));
        player.getStatistics().add(stats);
        
        player.setAppearancePercentage(stats.getAppearancePercentage());
        player.setStarterPercentage(stats.getStarterPercentage());

        // Salva le ultime prestazioni in JSON per il grafico "Form"
        try {
            player.setRecentPerformanceJson(objectMapper.writeValueAsString(recentMatches));
        } catch (Exception e) {
            log.error("[SYNC] Failed to serialize recent matches: {}", e.getMessage());
        }

        player.setTalentScore(scoutingService.calculateTalentScore(player, stats));
        player.setHiddenGemScore(scoutingService.calculateHiddenGemScore(player, stats));

        // NUOVA LOGICA: Popolamento automatico Tab (OTW e Hidden Gems)
        // OTW: Talent >= 75 e Età <= 24
        player.setIsConsigliato(player.getTalentScore() >= 75.0 && (player.getAge() != null && player.getAge() <= 24));
        // Hidden Gem: Gem Score >= 70 e Età <= 23
        player.setIsHiddenGem(player.getHiddenGemScore() >= 70.0 && (player.getAge() != null && player.getAge() <= 23));

        playerRepository.save(player);
        log.info("[SYNC] Stats aggregated and saved for {}. Goals: {}, Assists: {}, Apps: {}", player.getName(), goals, assists, appearances);
    }
}

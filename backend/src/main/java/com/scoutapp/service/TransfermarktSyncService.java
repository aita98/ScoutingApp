package com.scoutapp.service;

import com.scoutapp.client.TransfermarktClient;
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

@Service
@RequiredArgsConstructor
@Slf4j
public class TransfermarktSyncService {

    private final TransfermarktClient transfermarktClient;
    private final PlayerRepository playerRepository;
    private final PlayerStatsRepository playerStatsRepository;
    private final ScoutingService scoutingService;

    @Transactional
    public void syncAndAggregateStats(Long playerId, String tmId, String targetSeason) {
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

        for (TMPerformanceResponse.TMMatch match : performanceList) {
            if (match.getGameInformation() == null || match.getGameInformation().getSeason() == null) continue;
            
            String gameSeason = match.getGameInformation().getSeason().getNonCyclicalName();
            if (!targetSeason.equals(gameSeason)) continue;

            String participation = match.getParticipationState();
            if (participation == null && match.getStatistics() != null && match.getStatistics().getGeneralStatistics() != null) {
                participation = match.getStatistics().getGeneralStatistics().getParticipationState();
            }

            if ("played".equals(participation) || "in squad".equals(participation)) {
                appearances++;

                if (match.getStatistics() != null) {
                    var playingTime = match.getStatistics().getPlayingTimeStatistics();
                    if (playingTime != null) {
                        if (Boolean.TRUE.equals(playingTime.getIsStarting())) starts++;
                        if (playingTime.getPlayedMinutes() != null) minutes += playingTime.getPlayedMinutes();
                    }

                    var goalStats = match.getStatistics().getGoalStatistics();
                    if (goalStats != null) {
                        if (goalStats.getGoalsScoredTotalOfficial() != null) goals += goalStats.getGoalsScoredTotalOfficial();
                        if (goalStats.getAssistsOfficial() != null) assists += goalStats.getAssistsOfficial();
                    }

                    var cardStats = match.getStatistics().getCardStatistics();
                    if (cardStats != null) {
                        if (cardStats.getYellowCardGross() != null && cardStats.getYellowCardGross() > 0) yellowCards++;
                        if (cardStats.getYellowRedCard() != null && (cardStats.getRedCardsRescinded() == null || cardStats.getRedCardsRescinded() == 0)) {
                            redCards++;
                        }
                    }
                }
            }
        }

        Player player = playerRepository.findById(playerId).orElseThrow();
        
        // Clean targetSeason to convert to Integer if needed, or keep as String if the entity supports it
        // Looking at Hibernate logs, 'season' in player_stats seems to be a field.
        // Let's assume the entity PlayerStats has a String or Integer season. 
        // Based on TransfermarktRepository, it used Integer 2025. 
        // But the nonCyclicalName is "25/26".
        
        Integer seasonInt = 2025; // Default for 25/26
        if (targetSeason.contains("/")) {
            try {
                String yearPart = targetSeason.split("/")[0];
                seasonInt = 2000 + Integer.parseInt(yearPart);
            } catch (Exception e) {}
        }

        final Integer finalSeason = seasonInt;
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

        playerStatsRepository.save(stats);
        
        if (player.getStatistics() == null) player.setStatistics(new ArrayList<>());
        player.getStatistics().removeIf(ps -> ps.getSeason().equals(finalSeason));
        player.getStatistics().add(stats);
        
        // Update talent scores based on new stats
        player.setTalentScore(scoutingService.calculateTalentScore(player, stats));
        player.setHiddenGemScore(scoutingService.calculateHiddenGemScore(player, stats));
        
        playerRepository.save(player);
        log.info("[SYNC] Stats aggregated and saved for {}. Goals: {}, Assists: {}, Apps: {}", player.getName(), goals, assists, appearances);
    }
}

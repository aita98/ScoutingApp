package com.scoutapp.service;

import com.scoutapp.client.FootballDataClient;
import com.scoutapp.client.SportsDbClient;
import com.scoutapp.entity.Player;
import com.scoutapp.entity.PlayerStats;
import com.scoutapp.entity.ScoutEvent;
import com.scoutapp.repository.PlayerRepository;
import com.scoutapp.repository.PlayerStatsRepository;
import com.scoutapp.repository.ScoutEventRepository;
import com.scoutapp.repository.TransfermarktRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Lazy;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class DataSyncService {

    private final FootballDataClient footballDataClient;
    private final SportsDbClient sportsDbClient;
    private final PlayerRepository playerRepository;
    private final PlayerStatsRepository playerStatsRepository;
    private final ScoutEventRepository scoutEventRepository;
    private final ScoutingService scoutingService;
    private final NotificationService notificationService;
    private final TransfermarktRepository transfermarktRepository;
    private final DataSyncService self;

    public DataSyncService(
            FootballDataClient footballDataClient,
            SportsDbClient sportsDbClient,
            PlayerRepository playerRepository,
            PlayerStatsRepository playerStatsRepository,
            ScoutEventRepository scoutEventRepository,
            ScoutingService scoutingService,
            NotificationService notificationService,
            TransfermarktRepository transfermarktRepository,
            @Lazy DataSyncService self) {
        this.footballDataClient = footballDataClient;
        this.sportsDbClient = sportsDbClient;
        this.playerRepository = playerRepository;
        this.playerStatsRepository = playerStatsRepository;
        this.scoutEventRepository = scoutEventRepository;
        this.scoutingService = scoutingService;
        this.notificationService = notificationService;
        this.transfermarktRepository = transfermarktRepository;
        this.self = self;
    }

    @Transactional
    public void syncLeaguePlayers(String competitionCode) {
        log.info("Starting sync for competition {}", competitionCode);
        
        Map<String, Object> response = footballDataClient.getTopScorers(competitionCode);
        if (response == null || !response.containsKey("scorers")) return;

        List<Map<String, Object>> scorers = (List<Map<String, Object>>) response.get("scorers");
        for (Map<String, Object> scorer : scorers) {
            try {
                processScorerData(scorer, 2024);
            } catch (Exception e) {
                log.error("Error processing scorer: {}", e.getMessage());
            }
        }
        
        log.info("Sync completed for competition {}", competitionCode);
    }

    @Transactional
    public void syncAllLeagues() {
        List<String> leagues = List.of("PL", "PD", "SA", "BL1", "FL1", "ELC");
        for (String league : leagues) {
            try {
                syncLeaguePlayers(league);
                Thread.sleep(2000); 
            } catch (Exception e) {
                log.error("Failed to sync league {}: {}", league, e.getMessage());
            }
        }
    }

    @Transactional
    public void syncAllPlayersWithTM() {
        log.info("Starting bulk sync with Transfermarkt for all players...");
        List<Player> players = playerRepository.findAll();
        for (Player player : players) {
            try {
                transfermarktRepository.syncPlayerProfile(player.getId(), null);
                log.info("Synced {} with Transfermarkt", player.getName());
                Thread.sleep(1000); // Rate limit respect
            } catch (Exception e) {
                log.error("Failed to sync {} with TM: {}", player.getName(), e.getMessage());
            }
        }
    }

    private void processScorerData(Map<String, Object> scorer, Integer season) {
        Map<String, Object> playerData = (Map<String, Object>) scorer.get("player");
        Map<String, Object> teamData = (Map<String, Object>) scorer.get("team");
        
        Integer footballDataId = (Integer) playerData.get("id");
        String name = (String) playerData.get("name");

        Player player = playerRepository.findByApiFootballIdWithStats(footballDataId)
                .orElse(Player.builder()
                        .apiFootballId(footballDataId)
                        .talentScore(0.0)
                        .hiddenGemScore(0.0)
                        .statistics(new ArrayList<>())
                        .build());

        double oldTalentScore = player.getTalentScore();
        double oldHiddenGemScore = player.getHiddenGemScore();
        String oldClub = player.getClub();

        player.setName(name);
        player.setNationality((String) playerData.get("nationality"));
        player.setClub((String) teamData.get("name"));
        
        if (playerData.containsKey("dateOfBirth") && playerData.get("dateOfBirth") != null) {
            String dob = (String) playerData.get("dateOfBirth");
            try {
                int birthYear = Integer.parseInt(dob.split("-")[0]);
                player.setAge(java.time.Year.now().getValue() - birthYear);
            } catch (Exception e) {}
        }

        player.setLastUpdated(LocalDateTime.now());

        enrichWithSportsDb(player);

        if (player.getStatistics() == null) {
            player.setStatistics(new ArrayList<>());
        }

        Integer goals = (Integer) scorer.get("goals");
        Integer assists = (Integer) scorer.get("assists");
        Integer playedMatches = (Integer) scorer.get("playedMatches");

        PlayerStats stats = PlayerStats.builder()
                .player(player)
                .season(season)
                .goals(goals != null ? goals : 0)
                .assists(assists != null ? assists : 0)
                .appearances(playedMatches != null ? playedMatches : 0)
                .starts(playedMatches != null ? playedMatches : 0)
                .minutes((playedMatches != null ? playedMatches : 0) * 90)
                .yellowCards(0)
                .redCards(0)
                .build();

        player.getStatistics().removeIf(ps -> ps.getSeason().equals(stats.getSeason()));
        player.getStatistics().add(stats);

        player.setTalentScore(scoutingService.calculateTalentScore(player, stats));
        player.setHiddenGemScore(scoutingService.calculateHiddenGemScore(player, stats));

        playerRepository.save(player);
        generateEvents(player, oldTalentScore, oldHiddenGemScore, oldClub);
    }

    private void enrichWithSportsDb(Player player) {
        if (player.getPhotoUrl() != null && !player.getPhotoUrl().isEmpty()) return;

        try {
            Thread.sleep(500);
            Map<String, Object> sportsDbResponse = sportsDbClient.searchPlayer(player.getName());
            if (sportsDbResponse != null && sportsDbResponse.get("player") != null) {
                List<Map<String, Object>> players = (List<Map<String, Object>>) sportsDbResponse.get("player");
                if (!players.isEmpty()) {
                    Map<String, Object> sDbPlayer = players.get(0);
                    player.setPhotoUrl((String) sDbPlayer.get("strThumb"));
                    if (player.getPosition() == null) {
                        player.setPosition((String) sDbPlayer.get("strPosition"));
                    }
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (Exception e) {
            log.warn("Could not enrich player {} with SportsDB: {}", player.getName(), e.getMessage());
        }
    }

    private void generateEvents(Player p, double oldScore, double oldGemScore, String oldClub) {
        if (p.getTalentScore() >= oldScore + 10 && oldScore > 0) {
            saveEvent(p, "EXPLOSION", "Talent score increased significantly: +" + (p.getTalentScore() - oldScore));
        }
        if (p.getTalentScore() >= 85 && oldScore < 85) {
            saveEvent(p, "PROMOTION", "Promoted to ELITE PROSPECT status");
        }
        if (oldClub != null && !oldClub.equals(p.getClub())) {
            saveEvent(p, "TRANSFER", "Transferred from " + oldClub + " to " + p.getClub());
        }
        if (p.getHiddenGemScore() >= 60 && oldGemScore < 60) {
            saveEvent(p, "HIDDEN_GEM", "Identified as a new HIDDEN GEM profile");
        }
    }

    private void saveEvent(Player p, String type, String desc) {
        scoutEventRepository.save(ScoutEvent.builder()
                .player(p)
                .eventType(type)
                .description(desc)
                .createdAt(LocalDateTime.now())
                .build());
        
        if (type.equals("EXPLOSION") || type.equals("HIDDEN_GEM")) {
            notificationService.sendScoutingPushNotification(p, type, desc);
        }
    }
}

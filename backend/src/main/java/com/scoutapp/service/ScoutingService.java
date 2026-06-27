package com.scoutapp.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.scoutapp.dto.ComparisonDto;
import com.scoutapp.dto.RadarDataDto;
import com.scoutapp.entity.Player;
import com.scoutapp.entity.PlayerStats;
import com.scoutapp.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class ScoutingService {

    private final PlayerRepository playerRepository;
    private final ObjectMapper objectMapper;

    public double calculateTalentScore(Player player, PlayerStats stats) {
        if (stats == null || stats.getAppearances() == null || stats.getAppearances() == 0) return 0;

        int age = player.getAge() != null ? player.getAge() : 25;
        int goals = stats.getGoals() != null ? stats.getGoals() : 0;
        int assists = stats.getAssists() != null ? stats.getAssists() : 0;
        int minutes = stats.getMinutes() != null && stats.getMinutes() > 0 ? stats.getMinutes() : (stats.getAppearances() * 45);

        // Usa le percentuali pre-calcolate se disponibili, altrimenti calcola al volo
        double appearanceRate = stats.getAppearancePercentage() != null ? stats.getAppearancePercentage() : 
                               Math.min(100.0, ((double) stats.getAppearances() / 38.0) * 100.0);
        
        double starterPercentage = stats.getStarterPercentage() != null ? stats.getStarterPercentage() : 
                                  ((double) (stats.getStarts() != null ? stats.getStarts() : 0) / stats.getAppearances()) * 100.0;
        
        double goalContributionPer90 = ((double) (goals + assists) / minutes) * 90;

        return (100 - age) * 0.25 +
               appearanceRate * 0.25 +
               starterPercentage * 0.25 +
               (Math.min(1.0, goalContributionPer90) * 100) * 0.25;
    }

    public double calculateHiddenGemScore(Player player, PlayerStats stats) {
        if (stats == null || stats.getAppearances() == null || stats.getAppearances() == 0) return 0;

        int age = player.getAge() != null ? player.getAge() : 25;
        int goals = stats.getGoals() != null ? stats.getGoals() : 0;
        int assists = stats.getAssists() != null ? stats.getAssists() : 0;
        int minutes = stats.getMinutes() != null && stats.getMinutes() > 0 ? stats.getMinutes() : (stats.getAppearances() * 45);

        double appearanceRate = stats.getAppearancePercentage() != null ? stats.getAppearancePercentage() : 
                               Math.min(100.0, ((double) stats.getAppearances() / 38.0) * 100.0);
        
        double starterPercentage = stats.getStarterPercentage() != null ? stats.getStarterPercentage() : 
                                  ((double) (stats.getStarts() != null ? stats.getStarts() : 0) / stats.getAppearances()) * 100.0;
        
        double goalContributionPer90 = ((double) (goals + assists) / minutes) * 90;

        // Hidden Gem: Premia chi gioca meno ma è efficace quando entra (basso starterPercentage, alto goalContribution)
        double score = (100 - age) * 0.3 +
                       (Math.min(1.5, goalContributionPer90) * 100) * 0.4 +
                       ((100.0 - starterPercentage) * 0.2) + // Premia subentrati
                       (appearanceRate * 0.1);

        return Math.min(100.0, Math.max(0.0, score));
    }

    public ComparisonDto comparePlayers(Long idA, Long idB) {
        Player a = playerRepository.findById(idA).orElseThrow();
        Player b = playerRepository.findById(idB).orElseThrow();

        return ComparisonDto.builder()
                .playerA(mapToSummary(a))
                .playerB(mapToSummary(b))
                .build();
    }

    private ComparisonDto.PlayerSummary mapToSummary(Player p) {
        int goals = 0, assists = 0, minutes = 90, starts = 0, apps = 1;
        
        if (p.getStatistics() != null && !p.getStatistics().isEmpty()) {
            PlayerStats stats = p.getStatistics().get(0);
            goals = stats.getGoals() != null ? stats.getGoals() : 0;
            assists = stats.getAssists() != null ? stats.getAssists() : 0;
            minutes = (stats.getMinutes() != null && stats.getMinutes() > 0) ? stats.getMinutes() : 90;
            starts = stats.getStarts() != null ? stats.getStarts() : 0;
            apps = (stats.getAppearances() != null && stats.getAppearances() > 0) ? stats.getAppearances() : 1;
        }

        return ComparisonDto.PlayerSummary.builder()
                .name(p.getName())
                .club(p.getClub())
                .goalsPer90((double) goals / minutes * 90)
                .assistsPer90((double) assists / minutes * 90)
                .minutesPlayed(minutes)
                .starterPercentage(((double) starts / apps) * 100)
                .talentScore(p.getTalentScore())
                .hiddenGemScore(p.getHiddenGemScore())
                .build();
    }

    public RadarDataDto generateRadarData(Long id) {
        Player p = playerRepository.findById(id).orElseThrow();
        
        int goals = 0, assists = 0, appearances = 0;
        
        // Use Transfermarkt stats (already in DB from sync)
        if (p.getStatistics() != null && !p.getStatistics().isEmpty()) {
            PlayerStats stats = p.getStatistics().get(0);
            goals = stats.getGoals() != null ? stats.getGoals() : 0;
            assists = stats.getAssists() != null ? stats.getAssists() : 0;
            appearances = stats.getAppearances() != null ? stats.getAppearances() : 0;
        }

        log.info("[RADAR] Generating data for {}. Goals: {}, Assists: {}, Apps: {}", p.getName(), goals, assists, appearances);

        // Radar simulation logic
        int shooting = Math.min(99, 40 + (goals * 12));
        int passing = Math.min(99, 40 + (assists * 15));
        int dribbling = 70; // Placeholder
        int pace = 75; // Placeholder
        int physical = 65; // Placeholder
        int intelligence = 70; // Placeholder

        // Bonus for appearances (consistency)
        intelligence = Math.min(99, intelligence + (appearances / 2));

        return RadarDataDto.builder()
                .pace(pace)
                .shooting(shooting)
                .passing(passing)
                .dribbling(dribbling)
                .physical(physical)
                .intelligence(intelligence)
                .build();
    }
}

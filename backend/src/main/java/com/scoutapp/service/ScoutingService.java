package com.scoutapp.service;

import com.scoutapp.dto.ComparisonDto;
import com.scoutapp.dto.RadarDataDto;
import com.scoutapp.entity.Player;
import com.scoutapp.entity.PlayerStats;
import com.scoutapp.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ScoutingService {

    private final PlayerRepository playerRepository;

    public double calculateTalentScore(Player player, PlayerStats stats) {
        if (stats == null || stats.getAppearances() == null || stats.getAppearances() == 0 || stats.getMinutes() == null || stats.getMinutes() == 0) return 0;

        int age = player.getAge() != null ? player.getAge() : 25; // Default age if unknown
        int starts = stats.getStarts() != null ? stats.getStarts() : 0;
        int goals = stats.getGoals() != null ? stats.getGoals() : 0;
        int assists = stats.getAssists() != null ? stats.getAssists() : 0;

        double starterPercentage = ((double) starts / stats.getAppearances()) * 100;
        double goalContributionPer90 = ((double) (goals + assists) / stats.getMinutes()) * 90;

        return (100 - age) * 0.3 +
               starterPercentage * 0.4 +
               (goalContributionPer90 * 100) * 0.3;
    }

    public double calculateHiddenGemScore(Player player, PlayerStats stats) {
        if (stats == null || stats.getMinutes() == null || stats.getMinutes() == 0 || stats.getAppearances() == null || stats.getAppearances() == 0) return 0;

        int age = player.getAge() != null ? player.getAge() : 25;
        int starts = stats.getStarts() != null ? stats.getStarts() : 0;
        int goals = stats.getGoals() != null ? stats.getGoals() : 0;
        int assists = stats.getAssists() != null ? stats.getAssists() : 0;

        double starterPercentage = ((double) starts / stats.getAppearances()) * 100;
        double goalContributionPer90 = ((double) (goals + assists) / stats.getMinutes()) * 90;

        double score = (100 - age) * 0.25 +
                       (goalContributionPer90 * 100) * 0.45 +
                       ((70 - starterPercentage) * 0.10) +
                       (((double) stats.getMinutes() / 1800) * 20);

        return Math.min(100, Math.max(0, score));
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
        PlayerStats stats = p.getStatistics().get(0); // Latest season
        return ComparisonDto.PlayerSummary.builder()
                .name(p.getName())
                .club(p.getClub())
                .goalsPer90((double) stats.getGoals() / stats.getMinutes() * 90)
                .assistsPer90((double) stats.getAssists() / stats.getMinutes() * 90)
                .minutesPlayed(stats.getMinutes())
                .starterPercentage(((double) stats.getStarts() / stats.getAppearances()) * 100)
                .talentScore(p.getTalentScore())
                .hiddenGemScore(p.getHiddenGemScore())
                .build();
    }

    public RadarDataDto generateRadarData(Long id) {
        Player p = playerRepository.findById(id).orElseThrow();
        PlayerStats stats = p.getStatistics().get(0);

        // Proxy logic for radar chart based on position and basic stats
        // In a real scenario, this would use detailed match events (dribbles, tackles, etc.)
        int baseShooting = (int) Math.min(99, (stats.getGoals() * 10.0));
        int basePassing = (int) Math.min(99, (stats.getAssists() * 15.0));
        
        return RadarDataDto.builder()
                .pace(75) // Default placeholder
                .shooting(Math.max(40, baseShooting))
                .passing(Math.max(40, basePassing))
                .dribbling(70)
                .physical(65)
                .intelligence(70)
                .build();
    }
}

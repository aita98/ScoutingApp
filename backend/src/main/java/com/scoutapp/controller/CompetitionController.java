package com.scoutapp.controller;

import com.scoutapp.dto.LeagueDto;
import com.scoutapp.dto.TeamDto;
import com.scoutapp.dto.PlayerResponseDto;
import com.scoutapp.dto.transfermarkt.TransfermarktCompetitionClubsDto;
import com.scoutapp.dto.transfermarkt.TransfermarktPlayerDto;
import com.scoutapp.repository.TransfermarktRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/leagues")
@RequiredArgsConstructor
@Slf4j
public class CompetitionController {

    private final TransfermarktRepository transfermarktRepository;

    @GetMapping
    public List<LeagueDto> getLeagues() {
        return List.of(
            new LeagueDto(1L, "Premier League", "England", "GB1"),
            new LeagueDto(2L, "La Liga", "Spain", "ES1"),
            new LeagueDto(3L, "Serie A", "Italy", "IT1"),
            new LeagueDto(4L, "Bundesliga", "Germany", "L1"),
            new LeagueDto(5L, "Ligue 1", "France", "FR1"),
            new LeagueDto(6L, "Championship", "England", "GB2"),
            new LeagueDto(7L, "Serie B", "Italy", "IT2"),
            new LeagueDto(8L, "Liga Profesional", "Argentina", "AR1P"),
            new LeagueDto(9L, "Série A", "Brazil", "BRA1")
        );
    }

    @GetMapping("/{id}/teams")
    public List<TeamDto> getTeams(@PathVariable Long id) {
        log.info("Fetching teams for league ID: {}", id);
        String tmCode = getTmCode(id.intValue());

        try {
            // Target latest season 2025 (25/26), fallback to 2024
            List<TransfermarktCompetitionClubsDto.ClubDto> clubs = transfermarktRepository.getCompetitionClubs(tmCode, "2025");
            if (clubs == null || clubs.isEmpty()) {
                clubs = transfermarktRepository.getCompetitionClubs(tmCode, "2024");
            }
            
            return clubs.stream().map(club -> {
                Long idLong = Long.parseLong(club.getId());
                return new TeamDto(idLong, club.getName(), "", club.getImage());
            }).collect(Collectors.toList());
        } catch (Exception e) {
            log.error("Error fetching teams for {}: {}", tmCode, e.getMessage());
            return List.of();
        }
    }

    @GetMapping("/team/{teamId}/players")
    public List<PlayerResponseDto> getTeamPlayers(@PathVariable String teamId) {
        log.info("Fetching players for team TM ID: {}", teamId);
        try {
            List<TransfermarktPlayerDto> players = transfermarktRepository.getClubPlayers(teamId, "2025");
            if (players == null || players.isEmpty()) {
                players = transfermarktRepository.getClubPlayers(teamId, "2024");
            }

            return players.stream().map(p -> {
                long id = Long.parseLong(p.getId());
                return PlayerResponseDto.builder()
                    .id(id)
                    .name(p.getName())
                    .club(p.getClubName())
                    .age(p.getAge())
                    .marketValue(transfermarktRepository.parseMarketValue(p.getMarketValueDisplay()))
                    .talentScore(0.0)
                    .hiddenGemScore(0.0)
                    .position(p.getPosition())
                    .photoUrl(p.getImageUrl())
                    .build();
            }).collect(Collectors.toList());
        } catch (Exception e) {
            log.error("Error fetching team players {}: {}", teamId, e.getMessage());
            return List.of();
        }
    }

    private String getTmCode(int id) {
        return switch (id) {
            case 1 -> "GB1";
            case 2 -> "ES1";
            case 3 -> "IT1";
            case 4 -> "L1";
            case 5 -> "FR1";
            case 6 -> "GB2";
            case 7 -> "IT2";
            case 8 -> "AR1P";
            case 9 -> "BRA1";
            default -> "IT1";
        };
    }
}

package com.scoutapp.service;

import com.scoutapp.dto.AIScoutRequestDto;
import com.scoutapp.dto.AIScoutResponseDto;
import com.scoutapp.entity.Player;
import com.scoutapp.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AIService {

    private final PlayerRepository playerRepository;

    public AIScoutResponseDto performScouting(AIScoutRequestDto request) {
        if (request.getPlayerId() != null) {
            return analyzePlayerById(request.getPlayerId());
        } else if (request.getDescription() != null) {
            return analyzeDescription(request.getDescription());
        }
        throw new IllegalArgumentException("Invalid request: provide playerId or description");
    }

    private AIScoutResponseDto analyzePlayerById(Long id) {
        Player player = playerRepository.findById(id).orElseThrow();
        
        // Find similar players (same position, similar talent score)
        List<Player> similar = playerRepository.findAll().stream()
                .filter(p -> !p.getId().equals(id))
                .filter(p -> p.getPosition().equals(player.getPosition()))
                .sorted((p1, p2) -> Double.compare(
                        Math.abs(p1.getTalentScore() - player.getTalentScore()),
                        Math.abs(p2.getTalentScore() - player.getTalentScore())
                ))
                .limit(3)
                .collect(Collectors.toList());

        return AIScoutResponseDto.builder()
                .scoutingReport("Player " + player.getName() + " shows elite potential in " + player.getPosition() + ". Market value estimated around " + player.getMarketValue() + "M.")
                .similarPlayers(similar.stream().map(this::mapToSimilar).collect(Collectors.toList()))
                .similarityScore(90)
                .recommendations("Acquire immediately or monitor for 6 months.")
                .build();
    }

    private AIScoutResponseDto analyzeDescription(String description) {
        // Simple keyword-based logic (e.g. "winger", "striker")
        String pos = description.toLowerCase().contains("winger") ? "Attacker" : "Midfielder";
        
        List<Player> matches = playerRepository.findAll().stream()
                .filter(p -> p.getPosition().contains(pos))
                .limit(3)
                .collect(Collectors.toList());

        return AIScoutResponseDto.builder()
                .scoutingReport("AI identified profiles matching: " + description)
                .similarPlayers(matches.stream().map(this::mapToSimilar).collect(Collectors.toList()))
                .similarityScore(85)
                .recommendations("The following players match your scouting criteria.")
                .build();
    }

    private AIScoutResponseDto.SimilarPlayerDto mapToSimilar(Player p) {
        return AIScoutResponseDto.SimilarPlayerDto.builder()
                .id(p.getId())
                .name(p.getName())
                .club(p.getClub())
                .similarityScore(80)
                .build();
    }
}

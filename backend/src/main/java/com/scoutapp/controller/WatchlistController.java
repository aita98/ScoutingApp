package com.scoutapp.controller;

import com.scoutapp.dto.WatchlistDto;
import com.scoutapp.entity.Player;
import com.scoutapp.entity.Watchlist;
import com.scoutapp.repository.PlayerRepository;
import com.scoutapp.repository.WatchlistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/watchlist")
@RequiredArgsConstructor
public class WatchlistController {

    private final WatchlistRepository watchlistRepository;
    private final PlayerRepository playerRepository;

    @GetMapping
    public List<WatchlistDto> getWatchlist() {
        return watchlistRepository.findByUserId(1L).stream()
                .map(entry -> WatchlistDto.builder()
                        .id(entry.getId())
                        .playerId(entry.getPlayer().getId())
                        .playerName(entry.getPlayer().getName())
                        .club(entry.getPlayer().getClub())
                        .talentScore(entry.getPlayer().getTalentScore())
                        .dateAdded(entry.getDateAdded())
                        .build())
                .collect(Collectors.toList());
    }

    @PostMapping("/{playerId}")
    public WatchlistDto add(@PathVariable Long playerId) {
        Player player = playerRepository.findById(playerId).orElseThrow();
        
        Watchlist entry = Watchlist.builder()
                .userId(1L)
                .player(player)
                .dateAdded(LocalDateTime.now())
                .talentScoreAtAdd(player.getTalentScore())
                .hiddenGemScoreAtAdd(player.getHiddenGemScore())
                .build();
                
        Watchlist saved = watchlistRepository.save(entry);
        return WatchlistDto.builder()
                .id(saved.getId())
                .playerId(player.getId())
                .playerName(player.getName())
                .club(player.getClub())
                .talentScore(player.getTalentScore())
                .dateAdded(saved.getDateAdded())
                .build();
    }

    @DeleteMapping("/{playerId}")
    public void remove(@PathVariable Long playerId) {
        watchlistRepository.findByUserIdAndPlayer_Id(1L, playerId)
                .ifPresent(watchlistRepository::delete);
    }
}

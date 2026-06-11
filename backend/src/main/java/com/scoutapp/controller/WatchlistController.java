package com.scoutapp.controller;

import com.scoutapp.entity.Player;
import com.scoutapp.entity.Watchlist;
import com.scoutapp.repository.PlayerRepository;
import com.scoutapp.repository.WatchlistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/watchlist")
@RequiredArgsConstructor
public class WatchlistController {

    private final WatchlistRepository watchlistRepository;
    private final PlayerRepository playerRepository;

    @GetMapping
    public List<Watchlist> getWatchlist() {
        return watchlistRepository.findByUserId(1L); // Hardcoded user for now
    }

    @PostMapping("/{playerId}")
    public Watchlist add(@PathVariable Long playerId) {
        Player player = playerRepository.findById(playerId).orElseThrow();
        
        Watchlist entry = Watchlist.builder()
                .userId(1L)
                .player(player)
                .dateAdded(LocalDateTime.now())
                .talentScoreAtAdd(player.getTalentScore())
                .hiddenGemScoreAtAdd(player.getHiddenGemScore())
                .build();
                
        return watchlistRepository.save(entry);
    }

    @DeleteMapping("/{playerId}")
    public void remove(@PathVariable Long playerId) {
        watchlistRepository.findByUserIdAndPlayer_Id(1L, playerId)
                .ifPresent(watchlistRepository::delete);
    }
}

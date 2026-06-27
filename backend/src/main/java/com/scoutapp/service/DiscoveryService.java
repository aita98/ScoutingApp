package com.scoutapp.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.scoutapp.entity.Player;
import com.scoutapp.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class DiscoveryService {

    private final PlayerRepository playerRepository;
    private final ObjectMapper objectMapper;

    /**
     * Cross-platform discovery: ensures a player is linked to advanced stats (FBREF).
     */
    @Transactional
    public void discoverAndLink(Player player) {
        log.info("[DISCOVERY] Processing player for advanced stats: {}", player.getName());
        
        // Sofascore calls REMOVED as per requirements
        // FBRef discovery logic could be added here if needed to populate DB automatically
    }
}

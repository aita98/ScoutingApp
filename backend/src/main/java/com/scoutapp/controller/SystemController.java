package com.scoutapp.controller;

import com.scoutapp.service.DataSyncService;
import com.scoutapp.service.ScoutingService;
import com.scoutapp.repository.PlayerRepository;
import com.scoutapp.repository.PlayerStatsRepository;
import com.scoutapp.repository.ScoutEventRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/system")
@RequiredArgsConstructor
@Slf4j
public class SystemController {

    private final DataSyncService dataSyncService;
    private final PlayerRepository playerRepository;
    private final PlayerStatsRepository playerStatsRepository;
    private final ScoutEventRepository scoutEventRepository;

    @PostMapping("/startup")
    public ResponseEntity<Map<String, String>> startup() {
        // Avvia la sincronizzazione globale in background
        dataSyncService.syncAllLeagues();
        return ResponseEntity.ok(Map.of("message", "Backend Sync Started in background..."));
    }

    @PostMapping("/reset-data")
    public ResponseEntity<Map<String, String>> resetData() {
        try {
            log.info("Resetting all database data...");
            scoutEventRepository.deleteAll();
            playerStatsRepository.deleteAll();
            playerRepository.deleteAll();
            log.info("Database reset successful.");
            return ResponseEntity.ok(Map.of("message", "Database cleared successfully."));
        } catch (Exception e) {
            log.error("Reset failed", e);
            return ResponseEntity.status(500).body(Map.of("error", e.getMessage()));
        }
    }

    @GetMapping("/status")
    public ResponseEntity<Map<String, Object>> getStatus() {
        boolean dbOk = false;
        long playerCount = 0;
        try {
            playerCount = playerRepository.count();
            dbOk = true;
        } catch (Exception e) {
            log.error("Status check failed", e);
        }

        return ResponseEntity.ok(Map.of(
            "status", "RUNNING",
            "database", dbOk ? "CONNECTED" : "ERROR",
            "players_in_db", playerCount,
            "timestamp", System.currentTimeMillis()
        ));
    }
}

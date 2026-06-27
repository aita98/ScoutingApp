package com.scoutapp.controller;

import com.scoutapp.service.DataSyncService;
import com.scoutapp.service.SyncStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sync")
@RequiredArgsConstructor
public class SyncController {

    private final DataSyncService dataSyncService;
    private final SyncStatusService syncStatusService;

    @PostMapping("/league/{code}")
    public String syncLeague(@PathVariable String code) {
        dataSyncService.syncLeaguePlayers(code);
        return "Sync started for " + code;
    }

    @GetMapping("/status")
    public ResponseEntity<SyncStatusService.SyncStatusResponse> getSyncStatus() {
        return ResponseEntity.ok(syncStatusService.getStatus());
    }
}

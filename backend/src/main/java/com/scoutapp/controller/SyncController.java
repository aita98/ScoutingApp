package com.scoutapp.controller;

import com.scoutapp.service.DataSyncService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sync")
@RequiredArgsConstructor
public class SyncController {

    private final DataSyncService dataSyncService;

    @PostMapping("/league/{code}")
    public String syncLeague(@PathVariable String code) {
        dataSyncService.syncLeaguePlayers(code);
        return "Sync started for " + code;
    }
}

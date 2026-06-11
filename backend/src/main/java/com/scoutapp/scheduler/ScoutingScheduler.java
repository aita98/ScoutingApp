package com.scoutapp.scheduler;

import com.scoutapp.service.DataSyncService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class ScoutingScheduler {

    private final DataSyncService dataSyncService;

    // Ogni giorno alle 02:00
    @Scheduled(cron = "0 0 2 * * *")
    public void dailySync() {
        log.info("Executing daily player synchronization...");
        
        // Competition codes for Football-Data.org
        // Added: BSA (Brazil). Argentina/Colombia are often restricted in free tier.
        List<String> targetCompetitions = List.of("PL", "PD", "SA", "BL1", "FL1", "BSA");

        for (String code : targetCompetitions) {
            try {
                dataSyncService.syncLeaguePlayers(code);
            } catch (Exception e) {
                log.error("Error syncing competition {}: {}", code, e.getMessage());
            }
        }
    }
}

package com.scoutapp.config;

import com.scoutapp.repository.PlayerRepository;
import com.scoutapp.service.DataSyncService;
import com.scoutapp.service.SyncStatusService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DatabaseInitializer {

    @Autowired private PlayerRepository playerRepository;
    @Autowired private SyncStatusService syncStatusService;
    @Autowired private DataSyncService dataSyncService;

    @EventListener(ApplicationReadyEvent.class)
    public void initializeDatabaseOnStartup() {
        // Avviamo la sincronizzazione in background per non bloccare l'avvio del server
        new Thread(() -> {
            try {
                log.info("Starting automatic background sync for all leagues...");
                dataSyncService.syncAllLeagues();
            } catch (Exception e) {
                log.error("Error during startup sync: {}", e.getMessage());
            }
        }).start();
    }
}

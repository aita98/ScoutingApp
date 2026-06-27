package com.scoutapp.config;

import com.scoutapp.entity.Player;
import com.scoutapp.repository.PlayerRepository;
import com.scoutapp.service.SyncStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class DatabaseInitializer {

    @Autowired private PlayerRepository playerRepository;
    @Autowired private SyncStatusService syncStatusService;

    @EventListener(ApplicationReadyEvent.class)
    public void initializeDatabaseOnStartup() {
        // Avviamo lo screening in un thread separato per non bloccare l'avvio del server
        new Thread(() -> {
            try {
                syncStatusService.startSync();
                // Campionati target principali
                List<String> activeLeagues = List.of("Serie A", "Premier League", "LaLiga", "Bundesliga", "Ligue 1"); 
                
                int totalSteps = activeLeagues.size();
                int currentStep = 0;

                for (String league : activeLeagues) {
                    currentStep++;
                    syncStatusService.updateProgress(currentStep, totalSteps, "Scansione in corso: " + league);
                    
                    // Qui andrebbe la logica di chiamata al Proxy Django
                    // Esempio di elaborazioneBoundaries:
                    // double titolarita = ((double) player.getMinutesPlayed() / (totalMatches * 90)) * 100;
                    // player.setConsigliato(player.getAge() <= 25 && titolarita >= 70.0);
                    // player.setHiddenGem(player.getAge() <= 22 && titolarita >= 25.0 && titolarita <= 70.0);
                    
                    Thread.sleep(2000); // Simulazione caricamento
                }
                
                syncStatusService.endSync();
            } catch (Exception e) {
                syncStatusService.updateProgress(0, 100, "Errore durante la sincronizzazione: " + e.getMessage());
            }
        }).start();
    }
}

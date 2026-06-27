package com.scoutapp.service;

import org.springframework.stereotype.Service;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class SyncStatusService {
    private final AtomicBoolean isSyncing = new AtomicBoolean(false);
    private final AtomicInteger progress = new AtomicInteger(0);
    private String currentStatusMessage = "In attesa di avvio...";

    public void startSync() {
        this.isSyncing.set(true);
        this.progress.set(0);
    }

    public void updateProgress(int current, int total, String message) {
        int percentage = (int) (((double) current / total) * 100);
        this.progress.set(percentage);
        this.currentStatusMessage = message;
    }

    public void endSync() {
        this.isSyncing.set(false);
        this.progress.set(100);
        this.currentStatusMessage = "Sincronizzazione completata!";
    }

    public record SyncStatusResponse(boolean syncing, int progress, String message) {}

    public SyncStatusResponse getStatus() {
        return new SyncStatusResponse(isSyncing.get(), progress.get(), currentStatusMessage);
    }
}

package com.scoutapp.service;

import com.scoutapp.entity.Player;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class NotificationService {

    public void sendScoutingPushNotification(Player player, String eventType, String message) {
        // In un caso reale, qui integreremmo Firebase Cloud Messaging (FCM)
        log.info("PUSH NOTIFICATION SENT TO SCOUTS: [{}] for player {}. Message: {}", 
                 eventType, player.getName(), message);
    }
}

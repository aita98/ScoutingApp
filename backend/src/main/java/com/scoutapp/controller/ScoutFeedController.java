package com.scoutapp.controller;

import com.scoutapp.dto.ScoutFeedDto;
import com.scoutapp.entity.ScoutEvent;
import com.scoutapp.repository.ScoutEventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/scout-feed")
@RequiredArgsConstructor
public class ScoutFeedController {

    private final ScoutEventRepository scoutEventRepository;

    @GetMapping
    @Transactional(readOnly = true)
    public List<ScoutFeedDto> getFeed() {
        return scoutEventRepository.findAllByOrderByCreatedAtDesc().stream()
                .map(event -> {
                    var player = event.getPlayer();
                    return ScoutFeedDto.builder()
                        .id(event.getId())
                        .playerNames(player != null ? player.getName() : "Unknown")
                        .playerId(player != null ? player.getId() : null)
                        .photoUrl(player != null ? player.getPhotoUrl() : null)
                        .eventType(event.getEventType())
                        .description(event.getDescription())
                        .createdAt(event.getCreatedAt())
                        .build();
                })
                .collect(Collectors.toList());
    }
}

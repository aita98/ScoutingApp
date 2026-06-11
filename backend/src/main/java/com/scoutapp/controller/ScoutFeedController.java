package com.scoutapp.controller;

import com.scoutapp.entity.ScoutEvent;
import com.scoutapp.repository.ScoutEventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@RestController
@RequestMapping("/api/scout-feed")
@RequiredArgsConstructor
public class ScoutFeedController {

    private final ScoutEventRepository scoutEventRepository;

    @GetMapping
    @Transactional(readOnly = true)
    public List<ScoutEvent> getFeed() {
        return scoutEventRepository.findAllByOrderByCreatedAtDesc();
    }
}

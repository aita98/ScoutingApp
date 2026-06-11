package com.scoutapp.controller;

import com.scoutapp.dto.AIScoutRequestDto;
import com.scoutapp.dto.AIScoutResponseDto;
import com.scoutapp.service.AIService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ai")
@RequiredArgsConstructor
public class AIController {

    private final AIService aiService;

    @PostMapping("/scout")
    public AIScoutResponseDto scout(@RequestBody AIScoutRequestDto request) {
        return aiService.performScouting(request);
    }
}

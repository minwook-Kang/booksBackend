package com.aivle.bookapp.controller;

import com.aivle.bookapp.domain.AICoverRequest;
import com.aivle.bookapp.domain.AICoverResponse;
import com.aivle.bookapp.services.AICoverService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ai")
@RequiredArgsConstructor
public class AICoverController {

    private final AICoverService aiCoverService;

    @GetMapping("/test")
    public String test() {
        return "AI Cover API 정상 동작";
    }

    @PostMapping("/cover")
    public AICoverResponse generateCover(@Valid @RequestBody AICoverRequest request) {
        return aiCoverService.generateCover(request);
    }
}
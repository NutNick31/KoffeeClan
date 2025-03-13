package com.example.demo.controller;

import com.example.demo.service.AIService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ai")
public class AIController {

    private final AIService aiService;

    public AIController(AIService aiService) {
        this.aiService = aiService;
    }

    @GetMapping("/summarize/{id}")
    public String summarizeBlog(@PathVariable Long id) {
        return aiService.summarizeBlog(id);
    }
}

package com.example.producer.controller;

import com.example.producer.model.SentimentDto;
import com.example.producer.service.TwitterScheduler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:8080")
public class ChartController {
    private final TwitterScheduler twitterScheduler;

    @GetMapping("/chart-data/{keyword}")
    public List<SentimentDto> samplePublish(@PathVariable String keyword) {
        // TODO Make this Async
        log.info("{}", keyword);
        return twitterScheduler.doFixedDelayJob(keyword);
    }
}
package com.idf.cryptowatcher.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@EnableScheduling
public class ScheduledService {

    @Autowired
    private CoinService coinService;

    @Scheduled(fixedRateString = "60000")
    public void startScheduledTasks() {
        coinService.updateCoins();
    }
}
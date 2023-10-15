package com.keepthinker.example.simple.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;

import org.springframework.stereotype.Service;

@Service
public class SimpleService {
    private static final Logger logger = LoggerFactory.getLogger(SimpleService.class);

    @Async
    public void asyncTask() {
        logger.info("async task before");
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
        }
        logger.info("async task after");
    }
}

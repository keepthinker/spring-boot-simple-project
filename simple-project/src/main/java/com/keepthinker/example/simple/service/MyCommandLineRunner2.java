package com.keepthinker.example.simple.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(-2)
public class MyCommandLineRunner2 implements CommandLineRunner {
    @Override
    public void run(String... args) {
        System.out.println("-2 my command line runner");
    }
}

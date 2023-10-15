package com.keepthinker.example.simple.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class MyCommandLineRunner implements CommandLineRunner {

    @Autowired
    private MyApplicationArgumentService applicationArgumentService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("1 my command line runner");
        applicationArgumentService.printArguments();
    }
}

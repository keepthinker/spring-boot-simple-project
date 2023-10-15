package com.keepthinker.example.simple.service;

import com.keepthinker.example.simple.config.GeneralProperties;
import com.keepthinker.example.simple.config.OrderProperties;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class MyApplicationArgumentService {

    private static final Logger log = LoggerFactory.getLogger(MyApplicationArgumentService.class);

    private ApplicationArguments applicationArguments;
    private GeneralProperties generalProperties;
    private OrderProperties orderProperties;

    public MyApplicationArgumentService(ApplicationArguments arguments,
                                        GeneralProperties generalProperties,
                                        OrderProperties orderProperties) {
        this.applicationArguments = arguments;
        this.generalProperties = generalProperties;
        this.orderProperties = orderProperties;
    }

    @PostConstruct
    public void printArguments() {
        log.info("source args:{}", applicationArguments.getSourceArgs());
        log.info("non option args:{}", applicationArguments.getNonOptionArgs());
        log.info("option names:{}", applicationArguments.getOptionNames());
        log.info("option values:{}", applicationArguments.getOptionValues("mytype"));
        log.info("pay merchantIds:{}", generalProperties.getMerchantIds());
        log.info("order ids:{}", generalProperties.getOrderIds().stream().collect(Collectors.joining(" - ")));
        log.info("domain name:{}", generalProperties.getDomainName());
        log.info("order app key:{}", orderProperties.getAppKey());
        log.info("order base url:{}", orderProperties.getBaseUrl());
        log.info("order extra:{}", orderProperties.getExtra());
        log.info("order expire time:{} days", orderProperties.getExpireTime().toDays());


    }

}

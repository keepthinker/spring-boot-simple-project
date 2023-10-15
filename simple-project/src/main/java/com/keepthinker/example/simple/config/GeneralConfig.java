package com.keepthinker.example.simple.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(value = {GeneralProperties.class})
public class GeneralConfig {

    @ConfigurationProperties("order")
    @Bean
    public OrderProperties orderProperties() {
        return new OrderProperties();
    }
}

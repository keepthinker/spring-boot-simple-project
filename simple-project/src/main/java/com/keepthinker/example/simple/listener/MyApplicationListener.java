package com.keepthinker.example.simple.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 *
 c.k.e.s.listener.MyApplicationListener   : application event:org.springframework.boot.web.servlet.context.ServletWebServerInitializedEvent[source=org.springframework.boot.web.embedded.tomcat.TomcatWebServer@4833eff3]
 c.k.e.s.listener.MyApplicationListener   : application event:org.springframework.context.event.ContextRefreshedEvent[source=org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext@4af0df05, started on Thu Sep 28 21:47:12 CST 2023]
 c.k.example.simple.SimpleApplication     : Started SimpleApplication in 1.009 seconds (process running for 1.384)
 c.k.e.s.listener.MyApplicationListener   : application event:org.springframework.boot.context.event.ApplicationStartedEvent[source=org.springframework.boot.SpringApplication@4f8d86e4]
 c.k.e.s.listener.MyApplicationListener   : application event:org.springframework.boot.availability.AvailabilityChangeEvent[source=org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext@4af0df05, started on Thu Sep 28 21:47:12 CST 2023]
 -2 my command line runner
 1 my command line runner
 c.k.e.s.listener.MyApplicationListener   : application event:org.springframework.boot.context.event.ApplicationReadyEvent[source=org.springframework.boot.SpringApplication@4f8d86e4]
 c.k.e.s.listener.MyApplicationListener   : application event:org.springframework.boot.availability.AvailabilityChangeEvent[source=org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext@4af0df05, started on Thu Sep 28 21:47:12 CST 2023]
 */
@Component
public class MyApplicationListener implements ApplicationListener {
    private static final Logger logger = LoggerFactory.getLogger(MyApplicationListener.class);
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        logger.info("application event:{}", event);
    }
}

package com.keepthinker.example.simple;

import com.keepthinker.example.common.DecryptionService;
import com.keepthinker.example.common.EncryptionService;
import com.keepthinker.example.simple.service.SimpleService;
import com.keepthinker.example.simple.vo.Phone;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 * ENVIRONMENT VALUABLES:  DOMAIN_NAME: www.space-test.com
 */
@SpringBootApplication
@EnableAsync
public class SimpleApplication{

    public static void main(String[] args) {
        SpringApplication.run(SimpleApplication.class, args);

    }

}

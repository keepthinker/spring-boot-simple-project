package com.keepthinker.example.simple;

import com.keepthinker.example.common.DecryptionService;
import com.keepthinker.example.common.EncryptionService;
import com.keepthinker.example.simple.service.SimpleService;
import com.keepthinker.example.simple.vo.Phone;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 * ENVIRONMENT VALUABLES:  DOMAIN_NAME: www.space-test.com
 */
@RestController
@SpringBootApplication
@EnableAsync
public class SimpleApplication{
    @Autowired
    private SimpleService simpleService;

    @Autowired
    private EncryptionService encryptionService;

    @Autowired
    private ApplicationContext applicationContext;

    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }


    @RequestMapping("/phone")
    public Phone getPhone(){
        Phone phone = new Phone();
        phone.setName("phone name");
        phone.setPrice(10000);
        return phone;
    }

    @PutMapping("/phone")
    public Phone putPhone(@RequestBody Phone phone) {
        return phone;
    }

    @GetMapping(value = "/async-task", produces = "text/plain")
    public String asyncTask() {
        simpleService.asyncTask();
        return "async-task|" + System.currentTimeMillis();
    }

    @GetMapping(value = "/encrypt", produces = "text/plain")
    public String encrypt(@RequestParam String message) {
        return encryptionService.encrypt(message);
    }

    @GetMapping(value = "/decrypt", produces = "text/plain")
    public String decrypt(@RequestParam String message) {
        Map<String, DecryptionService> decryptionServices = applicationContext.getBeansOfType(DecryptionService.class);
        if (decryptionServices != null && !decryptionServices.isEmpty()) {
            return decryptionServices.entrySet().iterator().next().getValue().decrypt(message);
        } else {
            return "decryption is not turned on";
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(SimpleApplication.class, args);

    }

}

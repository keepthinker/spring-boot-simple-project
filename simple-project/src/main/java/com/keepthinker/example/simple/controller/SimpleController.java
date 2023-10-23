package com.keepthinker.example.simple.controller;

import com.keepthinker.example.common.DecryptionService;
import com.keepthinker.example.common.EncryptionService;
import com.keepthinker.example.simple.service.SimpleService;
import com.keepthinker.example.simple.vo.Phone;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

@RestController
public class SimpleController {

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

    @PostMapping("/phone")
    public String putPhone(@RequestBody String phone) {
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

    @RequestMapping("http-detail")
    public String httpDetail(HttpServletRequest request) throws IOException {
        System.out.format("url: %s\n", request.getRequestURL());

        Enumeration<String> headerNames = request.getHeaderNames();
        System.out.format("header --> value\n");
        while(headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            java.util.Enumeration<String> headers = request.getHeaders(headerName);
            StringBuilder headerValues = new StringBuilder();
            while (headers.hasMoreElements()) {
                headerValues.append(headers.nextElement().toString()).append(" ");
            }

            System.out.format("%s --> %s\n", headerName, headerValues);
        }

        System.out.format("body: \n");
        byte[] bytes = request.getInputStream().readAllBytes();
        String body = new String(bytes);
        System.out.println(body);

        return body;

    }
}

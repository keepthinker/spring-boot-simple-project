package com.keepthinker.example.simple;

import com.keepthinker.example.simple.vo.Phone;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class RestTemplateTest {

    private Logger logger = LoggerFactory.getLogger(RestTemplateTest.class);

    private static RestTemplate restTemplate;

    static {
        restTemplate = new RestTemplateBuilder()
                .setConnectTimeout(Duration.ofSeconds(3))
                .setReadTimeout(Duration.ofSeconds(3))
                .rootUri("http://localhost:8080").build();
    }


    @Test
    public void testPost(){
//        ResponseEntity<String> entity = restTemplate.getForEntity("https://www.baidu.com", String.class);
//        logger.info("entity: {}", entity.getBody());

        ResponseEntity<String> entity = restTemplate.postForEntity("/http-detail", new Phone("phone", 100), String.class);
        logger.info("entity: {}", entity.getBody());

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.put("content-type", List.of("application/json;charset=utf-8"));
        HttpEntity<Phone> requestEntity = new HttpEntity<Phone>(new Phone("phone", 100), httpHeaders);
        ResponseEntity<String> resp = restTemplate.exchange("/http-detail", HttpMethod.POST, requestEntity, String.class);
        logger.info("response body: {}", resp.getBody());
        logger.info("response code: {}", resp.getStatusCode());
        logger.info("response headers: {}", resp.getHeaders());


    }


}

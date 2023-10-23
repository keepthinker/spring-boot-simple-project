package com.keepthinker.example.simple.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("/redis/get")
    public @ResponseBody String get(@RequestParam("key") String key) {
        return String.valueOf(redisTemplate.opsForValue().get(key));
    }

    @RequestMapping("/redis/set")
    public void set(@RequestParam("key") String key, @RequestParam("value") String value) {
        redisTemplate.opsForValue().set(key, value);
    }
}

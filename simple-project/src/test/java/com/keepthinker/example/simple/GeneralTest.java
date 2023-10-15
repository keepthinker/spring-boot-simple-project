package com.keepthinker.example.simple;

import com.keepthinker.example.simple.service.SimpleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GeneralTest {

    @Autowired
    private SimpleService simpleService;

    @Test
    public void testSimpleService() {
        simpleService.asyncTask();
    }
}

package com.keepthinker.example.common;

import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Service
public class EncryptionService {

    public String encrypt(String str) {
        return new String(
                Base64.getEncoder().encode(str.getBytes(StandardCharsets.UTF_8)),
                StandardCharsets.UTF_8);
    }
}

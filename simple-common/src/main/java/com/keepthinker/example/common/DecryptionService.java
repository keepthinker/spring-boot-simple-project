package com.keepthinker.example.common;


import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class DecryptionService {

    public String decrypt(String str) {
        return new String(
                Base64.getDecoder().decode(str),
                StandardCharsets.UTF_8
        );
    }
}

package com.keepthinker.example.common;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@Import(EncryptionService.class)
public class CommonConfig {

    @Bean
    @ConditionalOnProperty(name = "base64.decryption.enable", havingValue = "true")
    public DecryptionService newDecryptionService() {
        return new DecryptionService();
    }

}

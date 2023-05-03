package com.atmosferpoc.shared.config.properties;

import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Setter
@Component
@ConfigurationProperties("encryption")
public class EncryptionContentProperties {
    private String encKey;

    public String getEncKey(String secondPart) {
        return encKey.concat(secondPart);
    }
}

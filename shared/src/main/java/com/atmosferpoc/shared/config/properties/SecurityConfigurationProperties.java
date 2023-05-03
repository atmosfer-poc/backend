package com.atmosferpoc.shared.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties("security")
public class SecurityConfigurationProperties {
    private int accessTokenMinutes;
    private int refreshTokenMinutes;
    private String key;
}

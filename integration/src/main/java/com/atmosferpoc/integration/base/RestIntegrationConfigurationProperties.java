package com.atmosferpoc.integration.base;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@ConfigurationProperties("integration")
public class RestIntegrationConfigurationProperties {
    private List<String> disableSslHostnames;
}

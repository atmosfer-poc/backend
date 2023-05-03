package com.atmosferpoc.integration.base;

public interface BaseIntegrationService <T extends BaseIntegrationConfigurationProperties> {
    T getProperties();
}

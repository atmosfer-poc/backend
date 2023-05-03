package com.atmosferpoc.integration.base;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BaseIntegrationConfigurationProperties {
    private String baseUrl;
    private Boolean mock;
}

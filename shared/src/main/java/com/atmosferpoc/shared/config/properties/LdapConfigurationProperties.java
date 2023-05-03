package com.atmosferpoc.shared.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("ldap")
public class LdapConfigurationProperties {
    private String namingProvider;
    private String securityPrincipal;
    private String contextFactory;
    private String connectionTimeoutProperty;
    private String connectionMaxInterval;
}

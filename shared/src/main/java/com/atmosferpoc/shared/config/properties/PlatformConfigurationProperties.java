package com.atmosferpoc.shared.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("platform")
public class PlatformConfigurationProperties {
    private String yaaniMailUrl;
    private String yaaniMailAdminUrl;
    private String bipMeetUrl;
    private String bipMeetAdminUrl;
    private String lifeBoxUrl;
    private String lifeBoxAdminUrl;
    private String buyUrl;
    private String ssoPasswordChangeUrl;
}

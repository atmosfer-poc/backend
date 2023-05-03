package com.atmosferpoc.shared.config.properties;

import com.atmosferpoc.shared.config.properties.pojo.MailContentPojo;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("mail-template")
public class MailContentProperties {

    private MailContentPojo createSubscription;
}

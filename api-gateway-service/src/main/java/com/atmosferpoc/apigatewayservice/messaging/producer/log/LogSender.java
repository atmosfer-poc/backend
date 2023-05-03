package com.atmosferpoc.apigatewayservice.messaging.producer.log;

import com.atmosferpoc.entity.log.PortalRequestLog;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;

@EnableBinding(Source.class)
public class LogSender {
    private final Source source;

    public LogSender(Source source) {
        this.source = source;
    }

    public void send(PortalRequestLog event) {
        source.output().send(MessageBuilder.withPayload(event).build());
    }
}

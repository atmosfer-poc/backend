package com.atmosferpoc.apigatewayservice.messaging.producer.log;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface Source {
    String OUTPUT = "log-output-channel";

    @Output(Source.OUTPUT)
    MessageChannel output();
}

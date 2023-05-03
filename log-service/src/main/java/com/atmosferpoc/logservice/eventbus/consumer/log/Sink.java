package com.atmosferpoc.logservice.eventbus.consumer.log;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface Sink {
    String INPUT = "log-input-channel";

    @Input(Sink.INPUT)
    SubscribableChannel input();
}
package com.atmosferpoc.logservice.eventbus.consumer.log;

import com.atmosferpoc.logservice.model.LogNotificationDto;
import com.atmosferpoc.logservice.service.LogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@Slf4j
@EnableBinding(Sink.class)
@RequiredArgsConstructor
public class LogConsumer {
    private final LogService logService;

    @StreamListener(Sink.INPUT)
    public void handler(LogNotificationDto dto) {
        try {
            log.info("Log Notification Event => {}", dto);
            logService.createLog(dto);
        } catch (Exception e) {
            log.error("Log Notification error => {}", e.getMessage());
        }
    }
}
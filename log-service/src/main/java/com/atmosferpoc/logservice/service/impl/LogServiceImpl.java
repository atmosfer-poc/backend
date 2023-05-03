package com.atmosferpoc.logservice.service.impl;

import com.atmosferpoc.logservice.model.Log;
import com.atmosferpoc.logservice.model.LogNotificationDto;
import com.atmosferpoc.logservice.repository.LogRepository;
import com.atmosferpoc.logservice.service.LogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class LogServiceImpl implements LogService {
    private final LogRepository repository;

    @Override
    public Log createLog(LogNotificationDto log) {
        var saveLog = new Log();
        saveLog.setId(UUID.randomUUID().toString().split("-")[0]);
        saveLog.setMessage(log.getMessage());
        saveLog.setLevel(log.getLevel());
        saveLog.setTimestamp(log.getTimestamp());

        return repository.save(saveLog);
    }
}

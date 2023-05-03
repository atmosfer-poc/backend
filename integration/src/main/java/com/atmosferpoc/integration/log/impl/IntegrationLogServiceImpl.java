package com.atmosferpoc.integration.log.impl;

import com.atmosferpoc.core.repository.BaseJpaRepository;
import com.atmosferpoc.core.service.AbstractEntityService;
import com.atmosferpoc.entity.log.IntegrationLog;
import com.atmosferpoc.integration.log.IntegrationLogService;
import com.atmosferpoc.integration.log.repository.IntegrationLogRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class IntegrationLogServiceImpl extends AbstractEntityService<IntegrationLog, Long> implements IntegrationLogService {
    private final IntegrationLogRepository repository;

    @Override
    public BaseJpaRepository<IntegrationLog, Long> getJpaRepository() {
        return repository;
    }
}

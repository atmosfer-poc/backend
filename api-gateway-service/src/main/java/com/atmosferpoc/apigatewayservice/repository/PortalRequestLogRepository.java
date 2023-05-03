package com.atmosferpoc.apigatewayservice.repository;

import com.atmosferpoc.entity.log.PortalRequestLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PortalRequestLogRepository extends JpaRepository<PortalRequestLog, Long> {
    Optional<PortalRequestLog> findByTransactionId(String trxId);
}

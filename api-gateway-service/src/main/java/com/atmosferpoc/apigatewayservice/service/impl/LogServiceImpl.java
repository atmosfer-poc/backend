package com.atmosferpoc.apigatewayservice.service.impl;

import com.atmosferpoc.apigatewayservice.messaging.producer.log.LogSender;
import com.atmosferpoc.apigatewayservice.model.log.RequestParameters;
import com.atmosferpoc.apigatewayservice.model.log.ResponseParameters;
import com.atmosferpoc.apigatewayservice.type.LogType;
import com.atmosferpoc.apigatewayservice.service.LogService;
import com.atmosferpoc.core.model.type.SourceVia;
import com.atmosferpoc.entity.User;
import com.atmosferpoc.entity.log.BaseWebLog;
import com.atmosferpoc.entity.log.PortalRequestLog;
import com.atmosferpoc.shared.constant.ApplicationConstants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class LogServiceImpl implements LogService {
    private final LogSender logSender;
    // TODO: bkocoglu buraya kafka consumer eklenecek

    @Override
    public void log(LogType type, RequestParameters requestParameters, ResponseParameters responseParameters) {
        try {
            var portalLog = new PortalRequestLog();

            fillForRequest(portalLog, requestParameters);

            fillForResponse(portalLog, responseParameters);

            if (Objects.nonNull(requestParameters.getUserId()) && requestParameters.getUserId() > 0) {
                var user = new User();
                user.setId(requestParameters.getUserId());
                portalLog.setUser(user);
            }

            logSender.send(portalLog);
        } catch (Exception ex) {
            log.warn(String.format(ApplicationConstants.ERROR_LOG_PATTERN, this.getClass().getSimpleName(), "log", "Can't request log", ex.getMessage()));
        }
    }

    private void fillForRequest(BaseWebLog log, RequestParameters parameters) {
        log.setRequest(parameters.getRequest());
        log.setPath(parameters.getPath());
        log.setTransactionId(parameters.getTrxId());
        log.setClient(parameters.getClient());
        log.setRequestHeaders(parameters.getHeaders());
        log.setHttpMethod(parameters.getHttpMethod());
        log.setCreatedBy(Objects.requireNonNullElse(parameters.getUserId(), 0L));
    }

    private void fillForResponse(BaseWebLog log, ResponseParameters parameters) {
        log.setResponse(parameters.getResponse());
        log.setDuration(parameters.getDuration());
        log.setResultCode(parameters.getResultCode());
        log.setResponseHeaders(parameters.getHeaders());
    }
}

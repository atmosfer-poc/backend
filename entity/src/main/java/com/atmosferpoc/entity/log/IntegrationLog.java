package com.atmosferpoc.entity.log;

import com.atmosferpoc.core.entity.BaseEntity;
import com.atmosferpoc.core.model.type.IntegrationLogProcessType;
import com.atmosferpoc.core.model.type.IntegrationLogServiceType;
import com.atmosferpoc.core.model.type.IntegrationLogStatusType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@Getter
@Setter
public class IntegrationLog extends BaseEntity {
    @Enumerated(EnumType.STRING)
    private IntegrationLogProcessType process;

    @Enumerated(EnumType.STRING)
    private IntegrationLogServiceType service;

    @Enumerated(EnumType.STRING)
    private IntegrationLogStatusType status;

    @Column(columnDefinition="TEXT")
    private String request;

    @Column(columnDefinition="TEXT")
    private String response;

    @Column(columnDefinition="TEXT")
    private String headers;

    @Column(columnDefinition="TEXT")
    private String description;

    private long duration;

    private String url;

    @Override
    public <T extends BaseEntity> void update(T entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public static IntegrationLog success(
            IntegrationLogProcessType process,
            IntegrationLogServiceType service,
            String request,
            String response,
            String headers,
            String description,
            long duration,
            String url) {
        return prepareLog(
                process,
                service,
                request,
                response,
                headers,
                description,
                duration,
                url,
                IntegrationLogStatusType.SUCCESS
        );
    }

    public static IntegrationLog error(
            IntegrationLogProcessType process,
            IntegrationLogServiceType service,
            String request,
            String response,
            String headers,
            String description,
            long duration,
            String url
    ) {
        return prepareLog(
                process,
                service,
                request,
                response,
                headers,
                description,
                duration,
                url,
                IntegrationLogStatusType.ERROR
        );
    }

    private static IntegrationLog prepareLog(
            IntegrationLogProcessType process,
            IntegrationLogServiceType service,
            String request,
            String response,
            String headers,
            String description,
            long duration,
            String url,
            IntegrationLogStatusType status
    ) {
        var log = new IntegrationLog();
        log.setProcess(process);
        log.setService(service);
        log.setStatus(status);
        log.setRequest(request);
        log.setResponse(response);
        log.setHeaders(headers);
        log.setDescription(description);
        log.setDuration(duration);
        log.setUrl(url);

        return log;
    }

    public static IntegrationLog mock(
            IntegrationLogProcessType process,
            IntegrationLogServiceType service
    ) {
        var log = new IntegrationLog();
        log.setProcess(process);
        log.setService(service);
        log.setStatus(IntegrationLogStatusType.MOCK);

        return log;
    }
}

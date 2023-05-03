package com.atmosferpoc.core.exception;

import com.atmosferpoc.core.model.type.IntegrationLogServiceType;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ServiceCallException extends RuntimeException {
    public ServiceCallException(IntegrationLogServiceType service, String message) {
        super(service + " " + message);
    }
}

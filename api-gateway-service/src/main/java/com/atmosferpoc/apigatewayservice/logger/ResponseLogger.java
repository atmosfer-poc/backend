package com.atmosferpoc.apigatewayservice.logger;

import com.atmosferpoc.apigatewayservice.model.log.ResponseParameters;
import com.atmosferpoc.apigatewayservice.type.LogType;
import com.atmosferpoc.core.constant.HeaderNameConstants;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.util.Pair;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;

public class ResponseLogger extends BaseWebLogger {
    private final HttpStatus status;
    private final LogType logType;

    public ResponseLogger(ServerHttpResponse response) {
        this.headers = response.getHeaders().toSingleValueMap();
        this.status = response.getStatusCode();
        this.logType = LogType.INTERNAL;
    }

    @Override
    public Pair<LogType, ResponseParameters> get() {
        var parameters = new ResponseParameters();
        parameters.setTrxId(getTrxId());
        parameters.setResponse(this.body);
        parameters.setDuration(getDuration());
        parameters.setResultCode(this.status.toString());
        parameters.setHeaders(this.headers.toString());

        return Pair.of(logType, parameters);
    }

    protected Long getDuration() {
        String durationStr = headers.get(HeaderNameConstants.TRANSACTION_DURATION);

        return StringUtils.isNotBlank(durationStr) ? Long.parseLong(durationStr) : 0L;
    }
}

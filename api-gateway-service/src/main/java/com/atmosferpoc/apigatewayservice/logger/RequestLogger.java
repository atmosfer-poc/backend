package com.atmosferpoc.apigatewayservice.logger;

import com.atmosferpoc.apigatewayservice.model.log.RequestParameters;
import com.atmosferpoc.apigatewayservice.type.LogType;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.util.Pair;
import org.springframework.http.HttpMethod;
import org.springframework.http.server.reactive.ServerHttpRequest;

import java.util.Objects;

public class RequestLogger extends BaseWebLogger {
    private final HttpMethod method;
    private final String client;
    private final LogType logType;
    private final String path;

    public RequestLogger(ServerHttpRequest request) {
        this.headers = request.getHeaders().toSingleValueMap();
        this.method = request.getMethod();
        this.client = Objects.requireNonNull(request.getRemoteAddress()).toString();
        this.path = getUriToFullPath(request);
        this.logType = LogType.INTERNAL;
    }

    private String getUriToFullPath(ServerHttpRequest request) {
        var path = request.getURI().getPath();

        var query = request.getURI().getQuery();

        if (StringUtils.isNotBlank(query)) {
            path = path.concat("?").concat(query);
        }

        return path;
    }

    @Override
    public Pair<LogType, RequestParameters> get() {
        var parameters = new RequestParameters();
        parameters.setRequest(body);
        parameters.setHeaders(headers.toString());
        parameters.setClient(client);
        parameters.setHttpMethod(method);
        parameters.setPath(path);
        parameters.setTrxId(getTrxId());
        parameters.setUserId(getUserId());

        return Pair.of(logType, parameters);
    }
}

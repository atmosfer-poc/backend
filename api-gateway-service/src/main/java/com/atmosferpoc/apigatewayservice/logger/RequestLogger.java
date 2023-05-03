package com.atmosferpoc.apigatewayservice.logger;

import com.atmosferpoc.apigatewayservice.model.log.RequestParameters;
import com.atmosferpoc.apigatewayservice.type.LogType;
import com.atmosferpoc.core.model.type.ChannelType;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.util.Pair;
import org.springframework.http.HttpMethod;
import org.springframework.http.server.reactive.ServerHttpRequest;

import java.util.Objects;

import static com.atmosferpoc.core.constant.HeaderNameConstants.AUTHENTICATED_CHANNEL_ID;

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
        String channel = headers.get(AUTHENTICATED_CHANNEL_ID);
        this.logType = (StringUtils.isBlank(channel) || ChannelType.fromId(Long.valueOf(channel)) != ChannelType.SUITE) ? LogType.EXTERNAL : LogType.INTERNAL;
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
        parameters.setChannelId(getChannelId());
        parameters.setUserId(getUserId());

        return Pair.of(logType, parameters);
    }
}

package com.atmosferpoc.apigatewayservice.secutiry;

import com.atmosferpoc.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;

@Slf4j
public abstract class AuthenticationApplier {
    public static final String BASIC_AUTH_PREFIX = "Basic ";
    public static final String BEARER_AUTH_PREFIX = "Bearer ";
    public static final String AUTHORIZATION_HEADER = "authorization";

    public abstract Optional<User> apply(ServerHttpRequest request);

    public abstract String getTokenPrefix();

    protected Optional<String> getToken(ServerHttpRequest request) {
        List<String> headerValues = request.getHeaders().get(AUTHORIZATION_HEADER);

        if (CollectionUtils.isEmpty(headerValues)) {
            return Optional.empty();
        }

        String authorizationValue = headerValues.get(0);

        String token = authorizationValue.replace(getTokenPrefix(), "");

        return Optional.of(token);
    }
}

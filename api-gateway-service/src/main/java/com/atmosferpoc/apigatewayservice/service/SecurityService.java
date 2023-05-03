package com.atmosferpoc.apigatewayservice.service;

import com.atmosferpoc.apigatewayservice.model.GuardResult;
import org.springframework.http.server.reactive.ServerHttpRequest;

public interface SecurityService {
    GuardResult checkGuard(ServerHttpRequest request);
}
